let btn1 = document.getElementById('btn1');
let btn2 = document.getElementById('btn2');

btn1.onclick = () => {
    alert('btn1이 클릭되었습니다.');
};

btn2.onclick = () => {
    alert('btn2이 클릭되었습니다.');

    btn1.onclick = null;
};

function test1() {
    alert('잘못 입력하셨습니다ddd.');
};

let btn3 = document.getElementById('btn3');

btn3.addEventListener('mouseenter', (event) => {
    event.target.style.backgroundColor = 'red';

    console.log(this)
    console.log(event)
});

btn3.addEventListener('mouseout', (event) => {
    event.target.style.backgroundColor = 'green';
});