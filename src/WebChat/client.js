const chatArea = document.getElementById('chatArea');
const messageInput = document.getElementById('messageInput');
const sendButton = document.getElementById('sendButton');

const webSocket = new WebSocket('ws://Public_IP_of_Machine_A:8080');

webSocket.onmessage = (event) => {
    const message = event.data;
    chatArea.innerHTML += '<p>' + message + '</p>';
};

sendButton.addEventListener('click', () => {
    const message = messageInput.value;
    webSocket.send(message);
    messageInput.value = '';
});
