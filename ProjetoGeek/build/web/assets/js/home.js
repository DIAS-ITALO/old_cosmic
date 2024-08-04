

const link = document.querySelector(".modal-form-comunidade");
const modal = document.querySelector("dialog");
const buttonClose = document.querySelector(".fechar-form");

link.onclick = function() {
    modal.showModal();
};

buttonClose.onclick = function() {
    modal.close();
};

