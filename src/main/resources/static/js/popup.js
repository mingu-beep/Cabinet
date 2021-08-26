function handleIdClick(event) {
  const memID = document.getElementById("memID").value;
  console.log(memID)
  var url = `/member/idCheck?value=${memID}`;
  var winWidth = 600;
  var winHeight = 500;
  var popupOption = "width=" + winWidth + ", height=" + winHeight;
  window.open(url, "아이디 중복 확인", popupOption);

}

function handleEmailClick(event) {
  const memEmail = document.getElementById("memEmail").value;
  var url = `/member/emailCheck?value=${memEmail}`;
  var winWidth = 600;
  var winHeight = 500;
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
