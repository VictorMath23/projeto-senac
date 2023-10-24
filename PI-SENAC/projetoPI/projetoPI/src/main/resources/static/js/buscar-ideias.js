$(document).ready(function () {
    // URL do endpoint da API para listar as ideias
    const listarIdeiasURL = "http://localhost:8080/ideia/listar-info";
    const buscarIdeiasURL = "http://localhost:8080/ideia/buscar-ideias";

    // Função para listar as ideias
    function listarIdeias() {
        $.ajax({
            url: listarIdeiasURL,
            method: "GET",
            dataType: "json",
            success: function (ideias) {
                atualizarTabelaIdeias(ideias);
            },
            error: function () {
                alert("Não foi possível listar as ideias.");
            },
        });
    }

    // Função para atualizar a tabela de ideias
    function atualizarTabelaIdeias(ideias) {
        // Limpa a tabela de ideias existente, se houver
        $("#my-table tbody").empty();

        // Itera sobre a lista de ideias e adiciona cada ideia à tabela
        ideias.forEach(function (ideia) {
            var newRow = $("<tr>");
            newRow.append("<td class='id'><strong>" + ideia.id + "</strong></td>");
            newRow.append("<td class='dono'>" + ideia.dono + "</td>");
            newRow.append("<td class='area'>" + ideia.area + "</td>");
            newRow.append("<td class='gestor'>" + ideia.gestor + "</td>");
            newRow.append("<td class='beneficio'>" + ideia.beneficio + "</td>");
            newRow.append("<td class='data'>" + ideia.dataIdeia + "</td>");
            newRow.append("<td class='status'>" + ideia.status + "</td>");
            newRow.append("<td class='detalhes'></td>"); // Você pode adicionar links de detalhes aqui

            // Adiciona a nova linha à tabela
            $("#my-table tbody").append(newRow);
        });
    }

    // Chama a função para listar as ideias quando a página é carregada
    listarIdeias();

    // Adiciona um evento de entrada ao campo de pesquisa
    $("#specificSizeInputName").on("input", function () {
        const dono = $(this).val();

        if (dono) { // Verifica se o campo de nome não está vazio
            $.ajax({
                url: buscarIdeiasURL,
                method: "GET",
                data: { dono: dono },
                dataType: "json",
                success: function (ideias) {
                    atualizarTabelaIdeias(ideias);
                },
                error: function () {
                    alert("Não foi possível buscar as ideias.");
                },
            });
        } else {
            // Se o campo de pesquisa estiver vazio, volte a listar todas as ideias
            listarIdeias();
        }
    });
});
