$(document).ready(() => {
    // $('h4:first').css('color', 'blue');
    // $('h4').first().css('color', 'blue');

    // $('h4:last').css({backgroundColor: 'blue', color: 'white'});

    // $('h4').filter(':odd').css({fontSize: '20px', color: 'green'});

    // $('.test').filter(':even').css({fontSize: '20px', color: 'skyblue'});

    // $('.test').filter((index) => {
    //     // 리턴 결과가 true인 요소만 걸러낸다.

    //     if(index === 0) {
    //         return false;
    //     }

    //     return index % 3 === 0;

    // }).css({fontSize: '20px', color: 'skyblue'});

    // 선택된 요소들 중 인덱스에 해당하는 요소를 가져와서 텍스트를 변경
    // $('h4').eq(4).text('4번 인덱스의 텍스트를 변경한다.');
    // $('h4:eq(4)').text('4번 인덱스의 텍스트를 변경한다.2');

    // 인자 값과 일치하지 않는 요소를 가져와서 스타일 변경
    // $('h4').not('.test').text('이게 여집합이다.');
    // $('h4:not(.test)').text('이게 여집합이다.');

    // $('h4').filter('.test').text('ㅋㅋㅋㅋㅋㅋ');

    // 2. Ancestors 메소드
    // 선택된 요소의 바로 상위에 있는 부모 요소
    console.log($('span').parent());
    
    // 선택된 요소의 모든 상위 요소
    console.log($('span').parents());

    // span 태그의 부모 요소에 스타일 설정
    // $('span').parent().css('backgroundColor', 'yellowgreen');

    // li 태그의 모든 상위 요소에 스타일 설정
    // $('li').parents().css('color', 'blue');
    
    // li 태그의 상위 요소 중 div만 스타일 설정
    // $('li').parents('div').css('color', 'blue');
    
    // span 태그부터 div 태그 이전까지 상위 요소 스타일 설정
    // $('span').parentsUntil('div').css('color', 'blue');

    // 3. Descendants 메소드
    console.log($('.wrap').children());
    console.log($('.wrap').find('span'));
    
    // 클래스명이 wrap인 태그의 자손의 스타일 변경
    // $('.wrap').children().css('color', 'hotpink');
    
    // 클래스명이 wrap인 태그의 자손의 자손들의 스타일 변경
    // $('.wrap').children().children().css('color', 'hotpink');
    
    // 클래스명이 wrap인 태그의 자손의 자손들 중 ul 태그의 스타일 변경
    // $('.wrap').children().children().children('li').css('color', 'hotpink');
    
    // 클래스명이 wrap인 태그의 모든 후손 중 span 태그의 스타일 변경
    // $('.wrap').find('span').css('color', 'hotpink');

    // 4. Sideways 메소드
    console.log($('.wrap1>h2').siblings());

    // h2 태그의 형제 요소들에 스타일 적용
    // $('.wrap1>h2').siblings().css({color: 'red', border: '2px solid'});
    
    // h2 태그의 형제 요소 중 p 태그에 스타일 적용
    // $('.wrap1>h2').siblings('p').css({color: 'red', border: '2px solid'});
    
    // h2 태그의 바로 다음 형제 요소에 스타일 적용
    // $('.wrap1>h2').next().css({color: 'red', border: '2px solid'});
    
    // h2 태그의 다음에 오는 모든 형제 요소에 스타일 적용
    // $('.wrap1>h2').nextAll().css({color: 'red', border: '2px solid'});
    
    // h2 태그 이후부터 p 태그 이전에 모든 형제 요소에 스타일 적용
    // $('.wrap1>h2').nextUntil('p').css({color:s 'red', border: '2px solid dashed'});
    
    // h2 태그의 이전 형제 요소에 스타일 적용
    // $('.wrap1>h2').prev().css({color: 'red', border: '2px solid dashed'});
    
    // h2 태그의 이전에 있는 모든 형제 요소에 스타일 적용
    // $('.wrap1>h2').prevAll().css({color: 'red', border: '2px solid dashed'});
    
    // h2 태그 이전부터 p태그 이후까지의 모든 형제 요소에 스타일 적용
    // $('.wrap1>h2').prevUntil('p').css({color: 'red', border: '2px solid dashed'});

    // 5. 요소가 있는지 찾는 메소드
    console.log($('.wrap1>span').nextAll().is('h4'));
    console.log($('.wrap1>span').is('.class1'));


});

