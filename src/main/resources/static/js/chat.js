var stompClient = null;

function connect() {
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    var x=document.getElementById('chatroomid').value;
        var headers = {
            'destination': `/room/${x}`
        };
    stompClient.connect(headers, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe(`/room/${x}`, function (response) {
            showMessage(JSON.parse(response.body).content);
        });
    },function (error) {
              console.error('STOMP 연결 중 에러 발생:', error);
              alert('STOMP 연결 중 에러가 발생했습니다.');
          });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}

function sendMessage() {
    var messageInput = document.getElementById('messageInput');
    var x=document.getElementById('chatroomid').value;
    var message = messageInput.value.trim();
    if (message) {
        stompClient.send(`/send/${x}`, {}, JSON.stringify({ 'content': message }));
        messageInput.value = '';
    }
}

function showMessage(message) {
    var messagesDiv = document.getElementById('messages');
    var messageElement = document.createElement('div');
    messageElement.innerText = message;
    messagesDiv.appendChild(messageElement);
}

document.getElementById('messageForm').addEventListener('submit', function (event) {
    event.preventDefault();
    sendMessage();
});

document.getElementById('messageout').addEventListener('submit', function (event) {

    disconnect();
});

connect();