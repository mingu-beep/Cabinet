function popUpOpen(event) {
  var url = "/member/idcheck";
  var winWidth = 700;
  var winHeight = 600;
  var popupOption = "width=" + winWidth + ", height=" + winHeight;
  window.open(url, "아이디 중복 확인", popupOption);
}

function init() {
  const btn = document.querySelector(".checkbtn");
  btn.addEventListener("click", popUpOpen);
}

init();
