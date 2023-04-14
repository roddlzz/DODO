# RESTful API로 spec 정의하기
### 1. 신규일정등록 (할일내용,날짜,메모,중요도,완료여부)  
Method : POST  
URL : /todos  

Request :  
```
{  
  "content": "할일 내용",  
  "date": "날짜 (yyyy-MM-dd)",  
  "memo": "메모",  
  "importance": "중요도",   
  "complete" : "완료여부"  
}  
```
Response :  
```
{  
  "id" : "일정 id",  
  "content": "할 일 내용",  
  "date": "날짜",  
  "memo": "메모",  
  "importance": true/false,  
  "complete": true/false  
}
```
### 2. 일정확인
Method : GET  
URL : /todos/{id}  
Response :  
```
{  
  "id": "일정 ID",  
  "content": "할일 내용",  
  "date": "날짜 (yyyy-MM-dd)",  
  "memo": "메모",  
  "importance": false,  
  "complete": false  
}
```
### 3. 일정수정 
Method : PUT  
URL : /todos/{id}  
Request :  
```
{  
  "content": "할일 내용",  
  "date": "날짜 (yyyy-MM-dd)",  
  "memo": "메모",  
  "importance": "중요도",   
  "complete" : "완료여부"  
} 
```
Response :  
```
{  
  "id" : "일정 id",  
  "content": "할 일 내용",  
  "date": "날짜",  
  "memo": "메모",  
  "importance": true/false,  
  "complete": true/false  
}
```
### 4. 일정삭제  
Method : DELETE  
URL : /todos/{id}

### 5. 일정 리스트 (지난일, 오늘, 내일, 이번주, 전체 리스트로 보이게 하기)
Method : GET  
URL : /todos  
Response :  
{  
"id": "일정 ID",  
"content": "할일 내용",  
"date": "날짜 (yyyy-MM-dd)",  
"memo": "메모",  
"importance": true/false,  
"complete": true/false  
}

### 6. 중요한일정 리스트
Method : GET  
URL : /todos/importance  
Response :  
{  
"id": "일정 ID",  
"content": "할일 내용",  
"date": "날짜 (yyyy-MM-dd)",  
"memo": "메모",  
"importance": true,  
"complete": true/false  
}
