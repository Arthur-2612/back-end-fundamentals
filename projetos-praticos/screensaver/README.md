# 🎨 Mini-Projeto: Protetor de Tela (ScreenSaver)

Aplicação desktop gráfica interativa desenvolvida com **Java Swing** e **AWT**, consolidando conceitos avançados de Orientação a Objetos, herança, polimorfismo, interfaces de evento e cálculo de física vetorial 2D simples para colisão de bordas.

---

## 🎯 Conceitos Aplicados

1. **Herança e Classes Abstratas:** A superclasse abstrata `FormaAnimada` padroniza o contrato de movimentação e renderização para qualquer elemento visual da tela.
2. **Polimorfismo:** Uma lista genérica `List<FormaAnimada>` armazena tanto instâncias de `Circulo` quanto de `Retangulo`. No loop de desenho, o método `desenhar(Graphics2D)` executa o comportamento específico de cada subclasse dinamicamente.
3. **Loop de Animação e Eventos:** Uso de `javax.swing.Timer` disparando eventos a cada 16ms (~60 frames por segundo), implementando a interface `ActionListener`.
4. **Física Básica de Colisão:** Inversão vetorial de velocidade (`dx = -dx`, `dy = -dy`) ao detectar o impacto das formas com os limites da janela.

---

## 🚀 Como Executar

A partir deste diretório (`projetos-praticos/screensaver/`):

```bash
# Compilar
javac ScreenSaverApp.java

# Executar aplicação gráfica
java ScreenSaverApp
```

---

## 📊 Estrutura de Arquivos

| Arquivo | Descrição |
|---|---|
| `ScreenSaverApp.java` | Classe principal com janela Swing, loop de renderização e hierarquia de formas geométricas |
| `README.md` | Documentação do mini-projeto |

