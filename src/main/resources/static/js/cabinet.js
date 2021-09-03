const locName = $(".locName").val();
function insertCabinet(){
    $.ajax({
        url: '/admin/cabinetInsert',
        type: 'post',
        data: {'locName' : locName},
        success: function(data){
            if(data == 1) cabinetList();
        },
        error: function(data){}
    });
}
function cabinetList() {
   $.ajax({
        url : '/admin/cnList?locName=' + locName,
        type : 'get',
        success : function(data){
            var a ='';
            $.each(data, function(key, value){
                a += '<tr class="cabinetContent'+value.cnNo+'">';
                a += '<td>' + value.cnNo + '</td>';
                a += '<td class="text-center cnLo' + value.cnLo + '">' + value.cnLo + '</td>';
                console.log(value.cnNo + " : "+ value.cnExist);
                if(value.cnReser != "CABINET_ADMIN"){
                    a += '<td class="cnExist'+value.cnNo+'">X</td>';
                    a += '<td>' + value.cnReser + '</td>'
                }
                else{
                    a += '<td>O</td>';
                    a += '<td></td>';
                }
                a
                a += '<td class="input-group-btn text-center"><a class="btn btn-notFocus py-0" onclick="cabinetDelete(' + value.cnNo + ')">삭제</a></td>';
                a += '</tr>';
            });
            $(".cabinetList").html(a);
        }
   });
}

function cabinetDelete(cnNo) {
    if(confirm(cnNo + "번 캐비넷을 삭제하시겠습니까?")){

        if($(".cnExist"+cnNo).text() == 'X'){
            alert("사용자가 있어 삭제할 수 없습니다.");
        }
        else {
            var a ='';
            $.ajax({
                url : '/admin/cabinetDelete/'+cnNo,
                type : 'post',
                data : {"locName": locName},
                success : function(data){
                    cabinetList();
                }
            });
        }
    }
}