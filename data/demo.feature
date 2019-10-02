Feature: Demo
  Es una ejecución para revisar el funcionamiento de la automatización
Scenario: MTC_0200_HP_UAT_CN_Tipo 3_DDA_CUENTA MAESTRA_INE NO DISPONIBLE_Celular Certificado
  Given Numero de ciente 85787738
  And Cliente tipo 7
  When Cliente no es el mostrado
  Then Inicia el proceso de alta TDD