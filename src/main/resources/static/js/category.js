function categoryList() {
    $.ajax({
        url : '/admin/ctList',
        type : 'get',
        success : function(data){
            var a ='';
            $.each(data, function(key, value){
                a += '<tr>';
                a += '<td>' + value.ctNo + '</td>';
                a += '<td class="ctType' + value.ctNo + '">' + value.ctType + '</td>';
                a += '<td class="text-center ctCNT"' + value.ctNo + '>' + value.ctCNT + '</td>';
                a += '<td><a class="btn btn-notFocus py-0" onclick="categoryUpdate(' + value.ctNo + ')">수정</a></td>';
                a += '<td><a class="btn btn-notFocus py-0" onclick="categoryDelete(' + value.ctNo + ')">삭제</a></td>';
                a += '</tr>';
            });

            $(".categoryList").html(a);
        }
    });
}

function categoryUpdate(ctNo) {
    if(confirm("카테고리를 수정하시겠습니까?")){
        var a = '';
        a += '<td>' + ctNo + '</td>';
        a += '<td><input type="text" class="form-control" name="content_'+ctNo+'" value="'+ $('.ctType'+ctNo).text() +'"/></td>';
        a += '<td class="text-center">' + $('.ctCNT' + ctNo).text() + '</td>';
        a += '<td class="input-group-btn"><button class="btn btn-focus py-0" type="button" onclick="categoryUpdateProc('+ctNo+');">수정</button> </td>';
        a += '<td class="input-group-btn"><button class="btn btn-notFocus py-0" type="button" onclick="categoryList();">취소</button> </td>';
        $('.categoryContent'+ctNo).html(a);
    }
}

function categoryUpdateProc(ctNo) {
    var updateContent = $('[name=content_' + ctNo + ']').val();

    $.ajax({
        url: '/admin/ctUpdate',
        type: 'post',
        data: {'ctNo' : ctNo,
               'ctType' : content},
        success: function(data){
            if(data == 1) categoryList();
        },
        error: function(data){}
    });
}

function categoryDelete(ctNo) {
    console.log(`Delete ${ctNo}`);
}