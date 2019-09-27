$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:demo.feature");
formatter.feature({
  "name": "Demo",
  "description": "  Es una ejecución para revisar el funcionamiento de la automatización",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "MTC_0200_HP_UAT_CN_Tipo 3_DDA_CUENTA MAESTRA_INE NO DISPONIBLE_Celular Certificado",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Numero de ciente 85787738",
  "keyword": "Given "
});
formatter.match({
  "location": "DemoSteps.numero_de_cliente_n(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Cliente tipo 7",
  "keyword": "And "
});
formatter.match({
  "location": "DemoSteps.cliente_tipo_n(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Cliente no es el mostrado",
  "keyword": "When "
});
formatter.match({
  "location": "DemoSteps.i_ask_whether_it_s_Friday_yet()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Inicia el proceso de alta TDD",
  "keyword": "Then "
});
formatter.match({
  "location": "DemoSteps.i_should_be_told()"
});
formatter.result({
  "status": "passed"
});
});