package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class CarroServiceTest {

    // Exemplo 1
    @Test
    public void deveAcelerarCorretamente() {
        // Dado:
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("azul", "fiat", "uno", 2020, 150);
        carroService.ligar(carro);

        // Quando:
        carroService.acelerar(carro, 10);

        // Então:
        Assert.assertEquals(10, carro.getVelocidadeAtual());
    }

    // Exemplo 2
    @Test
    public void naoDevePassarDaVelocidadeMaxima() {
        // Dado:
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("azul", "fiat", "uno", 2020, 100);
        carroService.ligar(carro);

        // Quando:
        carroService.acelerar(carro, 100);
        /* carroService.acelerar(carro, 100); */

        // Então:
        Assert.assertEquals(100, carro.getVelocidadeAtual());
    }

    // Exemplo 3
    @Test
    public void deveIniciarDesligado() {
        // Dado:
        Carro carro = new Carro("azul", "fiat", "uno", 2020, 100);

        // Então:
        // Assert.assertTrue();
        Assert.assertFalse(carro.isLigado());
    }


    // INICIO
    // DOS
    // TESTES


    // Teste #01
    @Test
    public void deveDesligarCorretamente() {
        // Dado (given)
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("Preto", "Chevrolet", "Monza", 1997, 180);
        carroService.ligar(carro);

        // Quando (when)
        carroService.desligar(carro);

        // Então (then)
        Assert.assertFalse(carro.isLigado());

    }

    // Teste #02
    @Test
    public void deveAcelerarEFrearCorretamente() {
        // Dado (given)
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("Cinza", "Fiat", "Uno Mille", 2007, 100);
        carroService.ligar(carro);

        // Quando (when)
        carroService.acelerar(carro, 10);
        carroService.frear(carro, 10);

        // Então (then)
        Assert.assertEquals(0, carro.getVelocidadeAtual());

    }

    // Teste #03
    @Test
    public void deveEstarParadoParaDesligar() {
        // Dado (given)
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("Branco", "Chevrolet", "Onix", 2018, 220);
        carroService.ligar(carro);
        carroService.acelerar(carro, 100);

        // Quando (when)
        carroService.frear(carro, 100);
        if(carro.getVelocidadeAtual() == 0) {
            carroService.desligar(carro);
        }

        // Então (then)
        Assert.assertEquals(0, carro.getVelocidadeAtual());
        Assert.assertFalse(carro.isLigado());

    }

    // Teste #04
    @Test
    public void deveLigarEAcelerarAtePassarSuaVelocidadeMaximaSemExtrapolar() {
        // Dado (given)
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("Azul", "Fiat", "Uno", 2020, 100);

        // Quando (when)
        carroService.ligar(carro);
        carroService.acelerar(carro, 160); // vel max: 100

        // Então (then)
        Assert.assertEquals(carro.getVelocidadeMaxima(), carro.getVelocidadeAtual());
    }

    // Teste #05
    @Test
    public void naoDeveDesligarEmMovimento() {
        // Dado (given)
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("Prata", "Volkswagen", "Polo", 2022, 240);
        carroService.ligar(carro);
        carroService.acelerar(carro, 80);

        // Quando (when)
            while (carro.getVelocidadeAtual() > 0) {
                carroService.frear(carro, 10);
            }
            carroService.desligar(carro);

        // Então (then)
        Assert.assertFalse(carro.isLigado());
    }

}