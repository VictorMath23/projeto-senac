function submitForm() {
    var nome = document.getElementById("nome").value;
    var matricula = document.getElementById("matricula").value;
    var areaAtuacao = document.getElementById("areaAtuacao").value;
    var gestor = document.getElementById("gestor").value;
    var beneficioIdeia = document.getElementById("beneficioIdeia").value;
    var data = document.getElementById("data").value;
    var ideia = document.getElementById("ideia").value;

    if (nome === "" || matricula === "" || areaAtuacao === "" || gestor === "" || beneficioIdeia === "" || data === "" || ideia === "") {
        alert("Todos os campos são obrigatórios. Por favor, preencha todos os campos.");
    } else {
        alert("Ideia enviada com sucesso!");
        // Limpa os campos após o envio bem-sucedido.
        document.getElementById("nome").value = "";
        document.getElementById("matricula").value = "";
        document.getElementById("areaAtuacao").value = "";
        document.getElementById("gestor").value = "";
        document.getElementById("beneficioIdeia").value = "";
        document.getElementById("data").value = "";
        document.getElementById("ideia").value = "";
    }
}

function toggleMenu() {
var menu = document.getElementById("menus");
var icon = document.querySelector(".iconh"); 
menu.classList.toggle("active");
if (menu.classList.contains("active")) {
    icon.style.marginLeft = "260px"; 
    icon.classList.add('aberto');
} else {
    icon.style.marginLeft = "5px"; 
    icon.classList.remove('aberto');
    icon.classList.add('fechado')
}
}

function fecharMenu() {
    var menu = document.getElementById("menus");
    menu.classList.remove("active");
}

