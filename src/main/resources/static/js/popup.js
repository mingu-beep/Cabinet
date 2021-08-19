function handleIdClick(event) {
  const memID = document.getElementById("memID").value;
  console.log(memID)
  var url = `/member/idCheck?id=${memID}`;
  var winWidth = 700;
  var winHeight = 600;
  var popupOption = "width=" + winWidth + ", height=" + winHeight;
  window.open(url, "아이디 중복 확인", popupOption);
}

function handleEmailClick(event) {
  const memEmail = document.getElementById("memEmail").value;
  console.log(memID)
  var url = `/member/emailCheck?email=${memEmail}`;
  var winWidth = 700;
  var winHeight = 600;
  var popupOption = "width=" + winWidth + ", height=" + winHeight;
  window.open(url, "이메일 중복 확인", popupOption);
}

function init() {
  const checkIdBtn = document.querySelector(".checkIdBtn");
  const checkEmailBtn = document.querySelector(".checkEmailBtn");
  checkIdBtn.addEventListener("click", handleIdClick);
  checkEmailBtn.addEventListener("click", handleEmailClick);
}

init();
