package cucumber;

import herramientas.Word;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import selenium.DemoSelenium;

import static org.junit.Assert.assertEquals;

public class DemoSteps extends DemoSelenium {
    private String today;
    private String actualAnswer;

    @Given("Numero de ciente {int}")
    public void numero_de_cliente_n(int cliente) {
        abrirUrl();
        //iniciarSesion();
    }

    @And("Cliente tipo {int}")
    public void cliente_tipo_n(int tipoCliente){
        System.out.println("Entre al And");
    }

    @When("^Cliente no es el mostrado$")
    public void i_ask_whether_it_s_Friday_yet() {
        //datosDeBusqueda();
    }

    @Then("^Inicia el proceso de alta TDD$")
    public void i_should_be_told() {
        System.out.println("Entre al Then");
        cerrarSesion();
        crearWord("CasoPruebaDemo",System.getProperty("user.dir") + "\\output");
    }
}
