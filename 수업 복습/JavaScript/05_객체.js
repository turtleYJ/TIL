let btn1 = document.getElementById('btn1');

btn1.addEventListener('click', () => {
    let area = document.getElementById('area1');

    let product = {
        0: '배열 흉내',
        pName: '아이폰 12 미니',
        price: 1000000,
        brand: '삼성',
        brand: '애플',
        spec: ['OLED', 'IOS15']  // 배열 데이터도 넣을 수 있다.
    };

    // 속성명을 제시할 때, 공백이나 특수문자가 들어가야 하는 경우 '',""로 묶어줘야 한다.
    let user = {
        'user-name': '정유일',
        'age!!': 20
    };

    console.log(product);

    area.innerHTML += `product: ${product} <br><br>`;

    area.innerHTML += '객체명["속성며"]으로 접근하는 방법<br>';
    area.innerHTML += `product[0]: ${product[0]} <br>`;
    area.innerHTML += `product['pName']: ${product['pName']} <br>`;
    area.innerHTML += `product['price']: ${product['price']} <br>`;
    area.innerHTML += `product['brand']: ${product['brand']} <br>`;
    area.innerHTML += `product['spec']: ${product['spec']} <br><br>`;

    area.innerHTML += '객체명.속성명으로 접근하는 방법<br>';
    // area.innerHTML += `product.0: ${product.0} <br>`
    area.innerHTML += `product.pName: ${product.pName} <br>`;
    area.innerHTML += `product.price: ${product.price} <br>`;
    area.innerHTML += `product.brand: ${product.brand} <br>`;
    area.innerHTML += `product.spec: ${product.spec} <br><br>`;

    area.innerHTML += '공백이나 특수문자가 속성명에 포함되어 있는 경우<br>';
    area.innerHTML += `user['user-name']: ${user['user-name']}<br>`
    area.innerHTML += `user['age!!']: ${user['age!!']}<br>`
});

// 객체의 메소드
let btn2 = document.getElementById('btn2');

btn2.addEventListener('click', () => {
    let dog = {
        name: '백구',
        kind: '진돗개',
        eat: function(food) {
            console.log(`${this.kind}종류인 ${this.name}가 ${food}를 먹고 있네요~!`);
        }
    };

    dog.eat('닭가슴살');
});

// 객체와 반복문
let btn3 = document.getElementById('btn3');

btn3.addEventListener('click', () => {
    let game = { 
        title: '디아블로2',
        price: 40000,
        supportOS: ['win32', 'win64'],
        servie: true
    }

    console.log(game);

    for (const key in game) {
        console.log(`key는 ${key}이고, 그 값은 ${game[key]}입니다.`);
    }
});

// 객체의 속성 추가 및 삭제
let btn4 = document.getElementById('btn4');

btn4.addEventListener('click', () => {
    // 빈 객체 선언
    let student = {};

    // 객체에 속성 추가
    student.name = '홍길동';
    student.age = 20;
    student['job'] = '의적';

    // 객체에 메소드 추가
    student.whoAreYou = function() {
        let str = '';

        for (const index in this) {
            if (typeof(this[index]) !== 'function') {
                str += `${index}: ${this[index]} `;                
            }
        }

        return str;
    }

    console.log(student);
    console.log(student.whoAreYou());
    console.log('job' in student);
    console.log('name' in student);
    
    delete(student.job);
    
    console.log(student);
    console.log(student.whoAreYou());
    console.log('job' in student);
    console.log('name' in student);
});

// 객체 배열
let btn5 = document.getElementById('btn5');

btn5.addEventListener('click', () => {
    let area = document.getElementById('area2');

    // 배열을 사용하지 않았을 경우
    let student1 = {name: '정유일', java: 100, oracle: 70};
    let student2 = {name: '홍길동', java: 70, oracle: 60};
    let student3 = {name: '백구', java: 100, oracle: 100};
    let student4 = {name: '누렁이', java: 800, oracle: 80};
    let student5 = {name: '이몽룡', java: 20, oracle: 20};

    // console.log(student1);
    // console.log(student2);
    // console.log(student3);
    // console.log(student4);
    // console.log(student5);

    // 배열 선언 및 초기화 (배열에 객체를 넣는다.)
    let students = [
        {name: '정유일', java: 100, oracle: 70},
        {name: '홍길동', java: 70, oracle: 60}
    ];

    // 배열에 요소 추가
    students.push({name: '백구', java: 100, oracle: 100});
    students.push(student4);
    students.push(student5);

    // 배열에 담겨있는 모든 객체에 메소드를 추가
    for (let i = 0; i < students.length; i++) {
        students[i].getSum = function() {
            return this['java'] + this['oracle']
        };

        students[i].getAvg = function() {
            return this.getSum() / 2;
        };        
    };

    console.log(students);

    // 모든 학생의 정보가 담긴 배열을 출력(이름, 총점, 평균)
    for (const index in students) {
        area.innerHTML += `이름: ${students[index]['name']}, 총점: ${students[index].getSum()}, 평균: ${students[index].getAvg()}<br><br>`
    };
});

