/**
 * ============================================================================
 * CURSO: DESENVOLVIMENTO BACK-END JAVA
 * AULA 09: SPRING BOOT E PADRÕES DE ARQUITETURA DE APIS RESTFUL
 * ============================================================================
 * 
 * Este arquivo demonstra de forma pura, didática e executável como o ecossistema
 * do Spring Boot opera sob o capô:
 * 1. O conceito de Injeção de Dependências (DI) e Inversão de Controle (IoC).
 * 2. O mapeamento de rotas e Verbos HTTP (GET, POST, DELETE).
 * 3. O encapsulamento de respostas com códigos de status HTTP (ResponseEntity).
 * 4. A separação clara entre Controller, Service e Repository.
 * ============================================================================
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// ----------------------------------------------------------------------------
// 1. MODEL / ENTITY: Tarefa (Representação do recurso REST)
// ----------------------------------------------------------------------------
class TaskEntity {

    private Long id;
    private String titulo;
    private boolean concluida;

    public TaskEntity(Long id, String titulo, boolean concluida) {
        this.id = id;
        this.titulo = titulo;
        this.concluida = concluida;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    // Serialização simulada para JSON
    public String toJson() {
        return String.format("{\"id\": %d, \"titulo\": \"%s\", \"concluida\": %b}", id, titulo, concluida);
    }
}

// ----------------------------------------------------------------------------
// 2. SIMULAÇÃO DE RESPOSTA HTTP (Equivalente ao ResponseEntity do Spring)
// ----------------------------------------------------------------------------
class MockResponseEntity<T> {

    private int statusCode;
    private String statusText;
    private T body;

    public MockResponseEntity(int statusCode, String statusText, T body) {
        this.statusCode = statusCode;
        this.statusText = statusText;
        this.body = body;
    }

    public static <T> MockResponseEntity<T> ok(T body) {
        return new MockResponseEntity<>(200, "200 OK", body);
    }

    public static <T> MockResponseEntity<T> created(T body) {
        return new MockResponseEntity<>(201, "201 Created", body);
    }

    public static <T> MockResponseEntity<T> notFound() {
        return new MockResponseEntity<>(404, "404 Not Found", null);
    }

    public static <T> MockResponseEntity<T> badRequest(T body) {
        return new MockResponseEntity<>(400, "400 Bad Request", body);
    }

    @Override
    public String toString() {
        return String.format("HTTP Response [%s] -> Body: %s", statusText, body);
    }
}

// ----------------------------------------------------------------------------
// 3. CAMADA REPOSITORY (No Spring: @Repository / JpaRepository)
// ----------------------------------------------------------------------------
class TaskRepositorySpring {

    private Map<Long, TaskEntity> db = new HashMap<>();
    private Long sequence = 1L;

    public TaskEntity save(String titulo) {
        TaskEntity task = new TaskEntity(sequence++, titulo, false);
        db.put(task.getId(), task);
        return task;
    }

    public List<TaskEntity> findAll() {
        return new ArrayList<>(db.values());
    }

    public TaskEntity findById(Long id) {
        return db.get(id);
    }

    public boolean deleteById(Long id) {
        return db.remove(id) != null;
    }
}

// ----------------------------------------------------------------------------
// 4. CAMADA SERVICE (No Spring: @Service com regras de negócio)
// ----------------------------------------------------------------------------
class TaskServiceSpring {

    private final TaskRepositorySpring repository;

    // Injeção de dependência via construtor (Boa prática recomendada pelo time do Spring)
    public TaskServiceSpring(TaskRepositorySpring repository) {
        this.repository = repository;
    }

    public TaskEntity criarTarefa(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título da tarefa não pode ser vazio!");
        }
        return repository.save(titulo.trim());
    }

    public List<TaskEntity> listarTarefas() {
        return repository.findAll();
    }

    public TaskEntity buscarPorId(Long id) {
        return repository.findById(id);
    }

    public boolean excluirTarefa(Long id) {
        return repository.deleteById(id);
    }
}

// ----------------------------------------------------------------------------
// 5. CAMADA CONTROLLER REST (No Spring: @RestController + @RequestMapping)
// ----------------------------------------------------------------------------
class TaskRestController {

    private final TaskServiceSpring service;

    public TaskRestController(TaskServiceSpring service) {
        this.service = service;
    }

    // Simula: @GetMapping("/api/tasks")
    public MockResponseEntity<?> getTasks() {
        List<TaskEntity> lista = service.listarTarefas();
        return MockResponseEntity.ok(lista.stream().map(TaskEntity::toJson).toList());
    }

    // Simula: @GetMapping("/api/tasks/{id}")
    public MockResponseEntity<?> getTaskById(Long id) {
        TaskEntity task = service.buscarPorId(id);
        if (task != null) {
            return MockResponseEntity.ok(task.toJson());
        }
        return MockResponseEntity.notFound();
    }

    // Simula: @PostMapping("/api/tasks")
    public MockResponseEntity<?> createTask(String titulo) {
        try {
            TaskEntity criada = service.criarTarefa(titulo);
            return MockResponseEntity.created(criada.toJson());
        } catch (IllegalArgumentException e) {
            return MockResponseEntity.badRequest("{\"erro\": \"" + e.getMessage() + "\"}");
        }
    }
}

// ----------------------------------------------------------------------------
// 6. CLASSE EXECUTÁVEL DEMO
// ----------------------------------------------------------------------------
public class ExemploAula09 {

    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println(" AULA 09: SIMULAÇÃO DE UMA API RESTFUL SPRING BOOT  ");
        System.out.println("====================================================\n");

        // Simulação do Spring IoC Container conectando as dependências
        TaskRepositorySpring repo = new TaskRepositorySpring();
        TaskServiceSpring service = new TaskServiceSpring(repo);
        TaskRestController controller = new TaskRestController(service);

        System.out.println("--- 1) Enviando requisição POST para /api/tasks ---");
        System.out.println("Cliente envia: { \"titulo\": \"Aprender Injeção de Dependências\" }");
        MockResponseEntity<?> res1 = controller.createTask("Aprender Injeção de Dependências");
        System.out.println("Resposta do Servidor: " + res1);

        System.out.println("\n--- 2) Enviando requisição POST inválida ---");
        MockResponseEntity<?> res2 = controller.createTask("");
        System.out.println("Resposta do Servidor: " + res2);

        System.out.println("\n--- 3) Enviando requisição GET para /api/tasks ---");
        MockResponseEntity<?> res3 = controller.getTasks();
        System.out.println("Resposta do Servidor: " + res3);

        System.out.println("\n--- 4) Enviando requisição GET para /api/tasks/1 ---");
        MockResponseEntity<?> res4 = controller.getTaskById(1L);
        System.out.println("Resposta do Servidor: " + res4);

        System.out.println("\n--- 5) Enviando requisição GET para /api/tasks/999 (Inexistente) ---");
        MockResponseEntity<?> res5 = controller.getTaskById(999L);
        System.out.println("Resposta do Servidor: " + res5);

        System.out.println("\nArquitetura RESTful e ciclo de vida do Spring Boot demonstrados com clareza!");
    }
}

