const messagePool = document.getElementById("message-pool");
const sendBtn = document.getElementById("send-btn");
const messageInput = document.getElementById("message-input");

function send(message) {
    const encodeMessage = encodeURI(message);

    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        let response = this.responseText;
        messagePool.innerHTML += "<div>" + response + "</div>";
    }
    xhttp.open("GET", "http://localhost:8080/hello?name=" + encodeMessage);
    xhttp.send();
}

function clearMessageInput() {
    messageInput.value = "";
}

sendBtn.addEventListener("click", () => {
    send(messageInput.value);
    clearMessageInput();
});

messageInput.addEventListener("keypress", (e) => {
    if (e.key === "Enter") {
        send(messageInput.value);
        clearMessageInput();
    }
});