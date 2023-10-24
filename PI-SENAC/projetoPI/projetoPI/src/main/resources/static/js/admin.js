$(document).ready(function () {
    // URL do endpoint da API para listar as ideias em análise
    const listarIdeiasURL = "http://localhost:8080/ideia/analise-com-proposta";

    // Variável de controle para evitar chamadas duplicadas
    let apiCallInProgress = false;

    // Função para listar as ideias em análise
    function listarIdeias() {
        // Verifica se a chamada à API já está em andamento
        if (apiCallInProgress) {
            return;
        }

        apiCallInProgress = true;

        $.ajax({
            url: listarIdeiasURL,
            method: "GET",
            dataType: "json",
            success: function (analises) {
                atualizarTabelaIdeias(analises);
                apiCallInProgress = false; // Marca a chamada como concluída
            },
            error: function () {
                alert("Não foi possível listar as ideias em análise.");
                apiCallInProgress = false; // Marca a chamada como concluída em caso de erro
            },
        });
    }

    // Função para atualizar a tabela de ideias
    function atualizarTabelaIdeias(analises) {
        // Limpa a tabela de ideias em análise no início
        $("#my-table-admin tbody").empty();

        // Itera sobre a lista de ideias e adiciona cada ideia à tabela
        analises.forEach(function (ideia) {
            var newRow = $("<tr>");
            newRow.append("<td class='id'><strong>" + ideia.id + "</strong></td>");
            newRow.append("<td class='dono'>" + ideia.dono + "</td>");
            newRow.append("<td class='area'>" + ideia.area + "</td>");
            newRow.append("<td class='gestor'>" + ideia.gestor + "</td>");
            newRow.append("<td class='beneficio'>" + ideia.beneficio + "</td>");
            newRow.append("<td class='data'>" + ideia.dataIdeia + "</td>");
            newRow.append("<td class='status'>" + ideia.status + "</td>");

            // Adicione a imagem "visibility" como um botão para abrir o modal
            var visibilityIcon = $("<img src='/img/visibility.png'>");
            var linkToModal = $("<a href='#staticBackdrop' data-bs-toggle='modal'></a>");
            linkToModal.append(visibilityIcon);
            linkToModal.on("click", function () {
                abrirModalDetalhes(ideia); // Abra o modal com os detalhes da ideia
            });
            newRow.append($("<td class='detalhes'></td>").append(linkToModal));

            // Adiciona a nova linha à tabela
            $("#my-table-admin tbody").append(newRow);
        });
    }

    // Função para abrir o modal com os detalhes da ideia
    function abrirModalDetalhes(ideia) {
    $("#modal-title").text("Detalhes da ideia:" + ideia.id);
    $("#modal-dono").text(ideia.dono);
    $("#modal-area").text(ideia.area);
    $("#modal-gestor").text(ideia.gestor);
    $("#modal-beneficio").text(ideia.beneficio);
    $("#modal-data").text(ideia.dataIdeia);
    $("#modal-status").text(ideia.status);
    $("#modal-proposta").text(ideia.proposta);

    $("#aprovarBtn").on("click", function () {
        aprovarIdeia(ideia.id);
    });

    $("#reprovarBtn").on("click", function () {
        reprovarIdeia(ideia.id);
    });

    // Abra o modal
    $("#staticBackdrop").modal("show");
}

function mostrarConfirmacaoAprovar(ideia) {
    const confirmaAprovacao = window.confirm("Deseja realmente aprovar esta ideia?");
    if (confirmaAprovacao) {
        aprovarIdeia(ideia.id);
    }
}

function mostrarConfirmacaoReprovar(ideia) {
    const confirmaReprovacao = window.confirm("Deseja realmente reprovar esta ideia?");
    if (confirmaReprovacao) {
        reprovarIdeia(ideia.id);
    }
}

function aprovarIdeia(ideiaId) {
    $.post("/ideia/aprovar/" + ideiaId, function () {
        alert("Ideia aprovada com sucesso.");
        // Recarregue a página para fechar o modal
        location.reload();
    });
}

function reprovarIdeia(ideiaId) {
    $.post("/ideia/reprovar/" + ideiaId, function () {
        alert("Ideia rejeitada com sucesso.");
        // Recarregue a página para fechar o modal
        location.reload();
    });
}

    // Chama a função para listar as ideias em análise quando a página é carregada
    listarIdeias();
});
