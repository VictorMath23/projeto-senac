$(document).ready(function () {
  //endpoints
  const adicionarIdeia = "http://localhost:8080/ideia/adicionar";

  function limpaCamposIdeia() {
    // Limpa o formulário
    $("#nome").val("");
    $("#matricula").val("");
    $("#areaAtuacao").val("");
    $("#gestor").val("");
    $("#beneficioIdeia").val("");
    $("#data").val("");
    $("#ideia").val("");
  }

  // Função para validar se todos os campos obrigatórios estão preenchidos
  function validarCampos() {
    const nome = $("#nome").val();
    const matricula = $("#matricula").val();
    const areaAtuacao = $("#areaAtuacao")[0].selectedIndex; // Obtém o índice selecionado
    const gestor = $("#gestor")[0].selectedIndex; // Obtém o índice selecionado
    const beneficioIdeia = $("#beneficioIdeia")[0].selectedIndex; // Obtém o índice selecionado
    const data = $("#data").val();
    const ideia = $("#ideia").val();

    if (
      !nome ||
      !matricula ||
      areaAtuacao === 0 || // Índice 0 indica "Selecione uma opção"
      gestor === 0 || // Índice 0 indica "Selecione uma opção"
      beneficioIdeia === 0 || // Índice 0 indica "Selecione uma opção"
      !data ||
      !ideia
    ) {
      alert("Preencha todos os campos obrigatórios.");
      return false; // Impede o envio do formulário
    }
    return true;
  }

  // cadastro de filme
 $("#idea-form").on("submit", function (event) {
  event.preventDefault();

  if (validarCampos()) {
    let ideias = {
      dono: $("#nome").val(),
      proposta: $("#ideia").val(),
      area: { id: parseInt($("#areaAtuacao").val()) },
       beneficio: { id: parseInt($("#beneficioIdeia").val()) },
       gestor: { id: parseInt($("#gestor").val()) },
      dataIdeia: $("#data").val(),
      status: "Analise"
    };

    $.ajax({
      url: adicionarIdeia,
      method: "POST",
      contentType: "application/json",
      data: JSON.stringify(ideias),
      success: function (data) {
        alert("Ideia cadastrada!");
        limpaCamposIdeia();
      },
      error: function () {
        alert("Não foi possível cadastrar a ideia.");
      },
      });
    }
  });
});
