package StepDefinitions;

import PageClass.PageClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinition {
     PageClass pageClass = new PageClass();

    @Given("Launch The Url")
    public void launch_the_url() {
        pageClass.launchurl();
    }
    @Given("Choose The First Option From Model Drop Down {string}")
    public void choose_the_first_option_from_model_drop_down(String CarModel) throws InterruptedException {
        pageClass.carmodel();
    }
    @Given("Choose The First Option From Fuel Type Drop Down {string}")
    public void choose_the_first_option_from_fuel_type_drop_down(String string) throws InterruptedException {
        pageClass.fueloption();
    }
    @Given("Choose The First Option From Variant Drop Down")
    public void choose_the_first_option_from_variant_drop_down() throws InterruptedException {
        pageClass.firstvarient();
    }
    @Given("Choose The First Option From Exterior Drop Down")
    public void choose_the_first_option_from_exterior_drop_down() throws InterruptedException {
        pageClass.extdropdown();
    }
    @Then("Choose The States Cities Dealers Respectively and Get the Product Details for each Selection")
    public void choose_the_states_cities_dealers_respectively_and_get_the_product_details_for_each_selection() throws InterruptedException {
        pageClass.enhance();
    }
}
