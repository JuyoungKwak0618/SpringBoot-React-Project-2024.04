// 1. Producer
const promise = new Promise((resolve, reject) => {
  // 네트워크 작업, 파일 작업 등으로 시간이 소요됨
  console.log('doing something...');
  setTimeout(() => {
    resolve('작업 결과');
    reject(new Error('에러 발생'));
  }, 2000);
});

// .. Consumer
promise
  .then(value => {
    console.log(value);
  })
  .catch(error => {
    console.log(error);
  });
