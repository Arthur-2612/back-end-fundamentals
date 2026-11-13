import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Mini-Projeto: Protetor de Tela (ScreenSaver) em Java Swing.
 * Demonstra Herança, Polimorfismo, Coleções e Computação Gráfica com Animação em 60 FPS.
 */
public class ScreenSaverApp extends JPanel implements ActionListener {

    // Lista polimórfica de formas geométricas
    private final List<FormaAnimada> formas = new ArrayList<>();
    private final Timer timer;

    public ScreenSaverApp() {
        setBackground(Color.BLACK);

        Random random = new Random();
        // Criação de 20 formas polimórficas (Círculos e Retângulos)
        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(600);
            int y = random.nextInt(400);
            int dx = random.nextInt(7) - 3;
            int dy = random.nextInt(7) - 3;
            if (dx == 0) dx = 2;
            if (dy == 0) dy = 2;
            Color cor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

            if (i % 2 == 0) {
                formas.add(new Circulo(x, y, dx, dy, 40 + random.nextInt(30), cor));
            } else {
                formas.add(new Retangulo(x, y, dx, dy, 40 + random.nextInt(30), 30 + random.nextInt(30), cor));
            }
        }

        // Loop de animação: ~60 atualizações por segundo (16ms)
        timer = new Timer(16, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // Ativa antialiasing para gráficos suaves
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Renderização polimórfica: cada forma desenha a si mesma
        for (FormaAnimada forma : formas) {
            forma.desenhar(g2d);
        }

        g2d.setColor(Color.WHITE);
        g2d.drawString("Java ScreenSaver - Mini Projeto Back-End POO", 15, 25);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Atualiza a posição de todas as formas e rebate nas bordas
        for (FormaAnimada forma : formas) {
            forma.mover(getWidth(), getHeight());
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Java Swing - Mini Projeto ScreenSaver");
        ScreenSaverApp painel = new ScreenSaverApp();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.add(painel);
        frame.setVisible(true);
    }
}

/**
 * Superclasse Abstrata que define o comportamento comum a qualquer forma animada.
 */
abstract class FormaAnimada {
    protected int x, y;
    protected int dx, dy;
    protected Color cor;

    public FormaAnimada(int x, int y, int dx, int dy, Color cor) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.cor = cor;
    }

    public abstract void desenhar(Graphics2D g);
    public abstract void mover(int larguraJanela, int alturaJanela);
}

/**
 * Círculo Animado que rebate nas bordas da janela.
 */
class Circulo extends FormaAnimada {
    private final int raio;

    public Circulo(int x, int y, int dx, int dy, int raio, Color cor) {
        super(x, y, dx, dy, cor);
        this.raio = raio;
    }

    @Override
    public void desenhar(Graphics2D g) {
        g.setColor(cor);
        g.fillOval(x, y, raio, raio);
    }

    @Override
    public void mover(int larguraJanela, int alturaJanela) {
        x += dx;
        y += dy;

        // Rebater nas bordas horizontais
        if (x <= 0 || x + raio >= larguraJanela) {
            dx = -dx;
        }
        // Rebater nas bordas verticais
        if (y <= 0 || y + raio >= alturaJanela) {
            dy = -dy;
        }
    }
}

/**
 * Retângulo Animado que rebate nas bordas da janela.
 */
class Retangulo extends FormaAnimada {
    private final int largura, altura;

    public Retangulo(int x, int y, int dx, int dy, int largura, int altura, Color cor) {
        super(x, y, dx, dy, cor);
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public void desenhar(Graphics2D g) {
        g.setColor(cor);
        g.fillRect(x, y, largura, altura);
    }

    @Override
    public void mover(int larguraJanela, int alturaJanela) {
        x += dx;
        y += dy;

        if (x <= 0 || x + largura >= larguraJanela) {
            dx = -dx;
        }
        if (y <= 0 || y + altura >= alturaJanela) {
            dy = -dy;
        }
    }
}
