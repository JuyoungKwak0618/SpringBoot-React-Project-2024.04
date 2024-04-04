function delay(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}

function getApple() {
  delay(1000);    //시간이 소요되는 작업
  return '맛있는 사과';
}

async function getBanana() {
  await delay(3000);
  return '제때 찾아오는 바나나';
}
console.log(getApple());
getBanana()
  .then(data => {console.log(data)});
