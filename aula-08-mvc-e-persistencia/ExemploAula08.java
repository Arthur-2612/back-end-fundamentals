/**
 * ============================================================================
 * CURSO: DESENVOLVIMENTO BACK-END JAVA
 * AULA 08: ARQUITETURA MVC (MODEL - VIEW - CONTROLLER) E PERSISTÊNCIA
 * ============================================================================
 * 
 * Demonstração prática dos seguintes tópicos:
 * 1. Camada MODEL (Entity): Representação dos dados (Tarefa).
 * 2. Camada REPOSITORY / DAO: Responsável por persistir e ler dados do disco/arquivo.
 * 3. Camada SERVICE: Onde residem as regras de negócio e validações.
 * 4. Camada CONTROLLER: Ponto de entrada que orquestra as ações.
 * 5. Camada VIEW: Exibição visual e formatação para o usuário.
 * ============================================================================
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// ----------------------------------------------------------------------------
// 1. MODEL (ENTITY): Tarefa
// ----------------------------------------------------------------------------
class Tarefa {

    private int id;
    private String descricao;
    private boolean concluida;

    public Tarefa(int id, String descricao, boolean concluida) {
        this.id = id;
        this.descricao = descricao;
        this.concluida = concluida;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    @Override
    public String toString() {
        return String.format("[%s] #%d: %s", (concluida ? "X" : " "), id, descricao);
    }
}

// ----------------------------------------------------------------------------
// 2. REPOSITORY / DAO: Persistência de Dados
// ----------------------------------------------------------------------------
class TarefaRepository {

    private final String ARQUIVO = "tarefas_db.txt";
    private List<Tarefa> bancoEmMemoria = new ArrayList<>();

    public TarefaRepository() {
        carregarDoDisco();
    }

    public void salvar(Tarefa tarefa) {
        bancoEmMemoria.add(tarefa);
        salvarNoDisco();
    }

    public List<Tarefa> listarTodas() {
        return new ArrayList<>(bancoEmMemoria);
    }

    public Tarefa buscarPorId(int id) {
        for (Tarefa t : bancoEmMemoria) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    private void salvarNoDisco() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO))) {
            for (Tarefa t : bancoEmMemoria) {
                writer.println(t.getId() + ";" + t.getDescricao() + ";" + t.isConcluida());
            }
        } catch (IOException e) {
            System.out.println("-> [DAO Erro] Falha ao gravar dados no disco: " + e.getMessage());
        }
    }

    private void carregarDoDisco() {
        File file = new File(ARQUIVO);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    int id = Integer.parseInt(partes[0]);
                    String desc = partes[1];
                    boolean conc = Boolean.parseBoolean(partes[2]);
                    bancoEmMemoria.add(new Tarefa(id, desc, conc));
                }
            }
        } catch (Exception e) {
            System.out.println("-> [DAO Erro] Falha na leitura do arquivo: " + e.getMessage());
        }
    }
}

// ----------------------------------------------------------------------------
// 3. SERVICE: Regras de Negócio e Validações
// ----------------------------------------------------------------------------
class TarefaService {

    private TarefaRepository repository;
    private int proximoId = 1;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
        // Ajusta o próximo ID baseado no banco existente
        for (Tarefa t : repository.listarTodas()) {
            if (t.getId() >= proximoId) {
                proximoId = t.getId() + 1;
            }
        }
    }

    public Tarefa cadastrarTarefa(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição da tarefa não pode ser vazia!");
        }
        Tarefa nova = new Tarefa(proximoId++, descricao.trim(), false);
        repository.salvar(nova);
        return nova;
    }

    public boolean concluirTarefa(int id) {
        Tarefa t = repository.buscarPorId(id);
        if (t != null) {
            t.setConcluida(true);
            return true;
        }
        return false;
    }

    public List<Tarefa> obterTodas() {
        return repository.listarTodas();
    }
}

// ----------------------------------------------------------------------------
// 4. CONTROLLER: Orquestrador da Aplicação
// ----------------------------------------------------------------------------
class TarefaController {

    private TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    public void processarNovaTarefa(String descricao) {
        try {
            Tarefa criada = service.cadastrarTarefa(descricao);
            System.out.println("-> [Controller: Sucesso] Tarefa criada com ID: " + criada.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("-> [Controller: Validação] " + e.getMessage());
        }
    }

    public void processarConclusao(int id) {
        boolean ok = service.concluirTarefa(id);
        if (ok) {
            System.out.println("-> [Controller: Sucesso] Tarefa #" + id + " marcada como concluída!");
        } else {
            System.out.println("-> [Controller: Falha] Tarefa com ID " + id + " não foi encontrada!");
        }
    }

    public List<Tarefa> processarListagem() {
        return service.obterTodas();
    }
}

// ----------------------------------------------------------------------------
// 5. VIEW & EXECUÇÃO PRINCIPAL
// ----------------------------------------------------------------------------
public class ExemploAula08 {

    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println(" AULA 08: DEMONSTRAÇÃO PRÁTICA DO PADRÃO MVC        ");
        System.out.println("====================================================\n");

        // Montagem das Camadas (Injeção Manual de Dependências)
        TarefaRepository repository = new TarefaRepository();
        TarefaService service = new TarefaService(repository);
        TarefaController controller = new TarefaController(service);

        // VIEW: Interações simuladas do usuário
        System.out.println("1) Cadastrando novas tarefas via Controller...");
        controller.processarNovaTarefa("Estudar Polimorfismo e Collections");
        controller.processarNovaTarefa("Implementar Padrão MVC em Java");
        controller.processarNovaTarefa(""); // Teste de validação

        System.out.println("\n2) Concluindo uma tarefa...");
        controller.processarConclusao(1);

        System.out.println("\n3) VIEW: Exibindo listagem final renderizada no console:");
        System.out.println("----------------------------------------------");
        System.out.println("              LISTA DE TAREFAS                ");
        System.out.println("----------------------------------------------");
        for (Tarefa t : controller.processarListagem()) {
            System.out.println("  " + t);
        }
        System.out.println("----------------------------------------------");
        System.out.println("Arquitetura MVC implementada com sucesso!");
    }
}

