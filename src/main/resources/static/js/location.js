function showCabinet(locNo){
    var url = "/admin/location/cabinet?locNo=" + locNo;
    var winWidth = 600;
    var winHeight = 520;
    var popupOption = "width=" + winWidth + ", height=" + winHeight;

    var popup = window.open(url, "Cabinet - 캐비넷 확인", popupOption);
}

function insertLocation() {
    var a = '';
    a += '<input type="text" class="form-control col-6 mr-4" name="newLocation"/>';
    a += '<button class="btn btn-focus py-0 mr-2" type="button" onclick="locationInsertProc();">추가</button>';
    a += '<button class="btn btn-notFocus py-0 mr-2" type="button" onclick="removeLocForm();">취소</button>';
    $('.insertLocationForm').html(a);
}

function removeLocForm() {
    var a = '';
    $('.insertLocationForm').html(a);
    locationList();
}
function locationInsertProc(){
    var newLocation = $('[name=newLocation]').val();

    $.ajax({
        url: '/admin/locInsert',
        type: 'post',
        data: {'locName' : newLocation},
        success: function(data){
            if(data == 1) removeLocForm();
        },
        error: function(data){}
    });
}
function locationList() {
   $.ajax({
        url : '/admin/locList',
        type : 'get',
        success : function(data){
            var a ='';
            $.each(data, function(key, value){
                a += '<tr class="locationContent'+value.locNo+'">';
                a += '<td>' + value.locNo + '</td>';
                a += '<td class="text-center locName' + value.locNo + '"><a onclick="showCabinet('+value.locNo+')">' + value.locName + '</a></td>';
                a += '<td class="text-center locCNT' + value.locNo + '">' + value.locCNT + '</td>';
                a += '<td class="input-group-btn text-center"><a class="btn btn-notFocus py-0" onclick="locationUpdate(' + value.locNo + ')">수정</a></td>';
                a += '<td class="input-group-btn text-center"><a class="btn btn-notFocus py-0" onclick="locationDelete(' + value.locNo + ')">삭제</a></td>';
                a += '</tr>';
            });
            $(".locationList").html(a);
        }
   });
}

function locationUpdate(locNo) {
    if(confirm("서비스 지역을 수정하시겠습니까?")){
        console.log("here!");
        var a = '';
        a += '<td>' + locNo + '</td>';
        a += '<td><input type="text" class="form-control" name="locContent_'+locNo+'" value="'+ $('.locName'+locNo).text() +'"/></td>';
        a += '<td class="text-center locCNT'+ locNo+'">' + $('.locCNT' + locNo).text() + '</td>';
        a += '<td class="input-group-btn text-center"><button class="btn btn-focus py-0" type="button" onclick="locationUpdateProc('+locNo+');">수정</button> </td>';
        a += '<td class="input-group-btn text-center"><button class="btn btn-notFocus py-0" type="button" onclick="locationList();">취소</button> </td>';
        $('.locationContent'+locNo).html(a);
    }
}

function locationUpdateProc(locNo) {
    var updateContent = $('[name=locContent_' + locNo + ']').val();

    $.ajax({
        url: '/admin/locUpdate',
        type: 'post',
        data: {'locNo' : locNo,
               'locName' : updateContent},
        success: function(data){
            if(data == 1) locationList();
        },
        error: function(data){}
    });
}
function locationDelete(locNo) {
    if(confirm("카테고리를 삭제하시겠습니까?")){
        var a ='';

        $.ajax({
            url : '/admin/locDelete/'+locNo,
            type : 'post',
            success : function(data){
                if(data == 1) locationList();
            }
        });
    }
}