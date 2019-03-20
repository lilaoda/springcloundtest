//获取用户信息
//var userStr = androidMethod.getUserInfo();
//var user = JSON.parse(userStr);

//查询运单
function searchWayBill() {
  var wayBill = $("#waybillcode_input").val();
  search(wayBill);
}


//调用相机扫描
function scanWayBill() {
var data={'param':"doScan",'data':null};
window.WebViewJavascriptBridge.callHandler(
                'doNativeMethod'
                , data
                , function(responseData) {

                }
            );
}

//设置扫描返回的运单
function setWaybillCodeText(waybill) {
  $("#waybillcode_input").val(waybill);
  search(waybill);
}

//获取焦点时查询运单信息
function searchBillInfo() {
  var waybill = $("#waybillcode_input").val();
  search(waybill);
}

//设置体积
function setVolumeText(weight, volume, count) {
  $("#open_weight").val(weight);
  $("#open_volume").val(volume);
  $("#open_count").val(count);
}

//添加一行
function addRow(rowObj) {
  var td = rowObj.parentNode;
  var imgd = td.getElementsByClassName("del_img");
  $(imgd).show();
  $(rowObj).hide();
  var table = document.getElementById("input_tb_id");
  var rowsNum = table.rows.length; //获取当前行数
  var colsNum = table.rows[0].cells.length; //获取行的列数
  var newRow = table.insertRow(rowsNum); //插入新行
  var newRowTd0 = newRow.insertCell(0);
  newRowTd0.innerHTML = " <input type='number' class='length_input' onkeyup='this.value=this.value.replace(/\D/g,'')' onafterpaste='this.value=this.value.replace(/\D/g,'')' />";
  var newRowTd1 = newRow.insertCell(1);
  newRowTd1.innerHTML = "<input type='number' class='width_input' onkeyup='this.value=this.value.replace(/\D/g,'')' onafterpaste='this.value=this.value.replace(/\D/g,'')' />";
  var newRowTd2 = newRow.insertCell(2);
  newRowTd2.innerHTML = "<input type='number' class='height_input' onkeyup='this.value=this.value.replace(/\D/g,'')' onafterpaste='this.value=this.value.replace(/\D/g,'')' />";
  var newRowTd3 = newRow.insertCell(3);
  newRowTd3.setAttribute("class", "last_td");
  newRowTd3.innerHTML = "<input type='number' class='count_input' onkeyup='this.value=this.value.replace(/\D/g,'')' onafterpaste='this.value=this.value.replace(/\D/g,'')' /><img src='img/icon_add.png' class='add_img' onclick='addRow(this)' /><img src='img/icon_del.png' class='del_img' onclick='removeRow(this)' />";
}

//删除一行
function removeRow(rowObj) {
  var table = document.getElementById('input_tb_id');
  //获取tr对象;
  var tr = rowObj.parentNode.parentNode;
  if (table.rows.length > 2) {
    //tr.parentNode指的是：table对象，移除子节点;
    tr.parentNode.removeChild(tr);
  }
}

//搜索运单信息
function search(waybill) {
  if (!waybill) {
    alert("运单号不能为空");
    return;
  }
  $("#loading").show();
  $.ajax({
    type: "get",
    url: "http://192.168.8.64",
    timeout: 10000,
    data: {
//      'jobnum': user.jobnum,
//      'username': user.username,
//      'deptid': user.deptid
    },
    dataType: "json",
    contentType: 'application/json;charset=utf-8',
    success: function(data) {
      $("#loading").hide();
      $("#open_weight").val(data.weight);
      $("#open_volume").val(data.volume);
      $("#open_count").val(data.count);
    },
    error: function(XMLHttpRequest, textStatus, errorThrown) {
      $("#loading").hide();
      setVolumeText(5.6, 0.5, 2);
      console.log("XMLHttpRequest.status==" + XMLHttpRequest.status);
      console.log("XMLHttpRequest.readyState==" + XMLHttpRequest.readyState);
      console.log("errorThrown" + errorThrown);
      if (textStatus == "error" || textStatus == null) {
        alert("链接错误");
      } else if (textStatus == "timeout") {
        alert("连接超时");
      } else if (textStatus == "parsererror") {
        alert("解析错误");
      } else {
       alert("查询失败");
      }
    }
  });
}

function addImg() {
  var imgList = document.getElementsByClassName("addImg");
  var imgPathList = new Array();
  for (var i = 0; i < imgList.length; i++) {
    imgPathList.push(imgList[i].name);
  }
var data={'param':"doAddImg",'data':imgPathList};
  window.WebViewJavascriptBridge.callHandler(
                  'doNativeMethod'
                  , data
                  , function(responseData) {

                  }
              );
}

function showImages(imageInfoList) {
var jsonObj =  JSON.parse(imageInfoList);//转换为json对象
var newPreview = document.getElementById("imagePreview");
    $(".imgdiv").remove();
    for(var i=0;i<jsonObj.length;i++){
      var imgdiv = document.createElement("div");
      imgdiv.setAttribute("class", "imgdiv");

      var img = document.createElement("img");
      img.setAttribute("class", "addImg");
      img.setAttribute("data-preview-src", "");
      img.setAttribute("data-preview-group", "1");
      img.setAttribute("name", jsonObj[i].absPath);
      img.src = jsonObj[i].base64Url;

      var imgdel = document.createElement("img");
      imgdel.setAttribute("class", "imgdel");
      imgdel.src = "img/del.png";
      imgdel.addEventListener("click", function deleteImg(e) {
        e.target.parentNode.remove();
      }, false);

      imgdiv.appendChild(img);
      imgdiv.appendChild(imgdel);
      newPreview.appendChild(imgdiv);
    }
}



//添加图片
function loadImageFile() {
  if (window.FileReader) {
    var oFReader = new window.FileReader();
    var z_file = document.getElementsByClassName("z_file");
    var aFiles = document.getElementById("imageInput").files;
    if (aFiles.length === 0) {
      return;
    }
    oFReader.readAsDataURL(aFiles[0]);
    oFReader.onload = function(oFREvent) {
      var newPreview = document.getElementById("imagePreview");

      var imgdiv = document.createElement("div");
      imgdiv.setAttribute("class", "imgdiv");

      var img = document.createElement("img");
      img.setAttribute("class", "addImg");
      img.setAttribute("data-preview-src", "");
      img.setAttribute("data-preview-group", "1");

      var imgdel = document.createElement("img");
      imgdel.setAttribute("class", "imgdel");
      imgdel.src = "img/del.png";
      imgdel.addEventListener("click", function deleteImg(e) {
        e.target.parentNode.remove();
      }, false);

      imgdiv.appendChild(img);
      imgdiv.appendChild(imgdel);
      newPreview.appendChild(imgdiv);
      img.src = oFREvent.target.result;
    };
  }
}

//获取表格的数据
function GetInfoFromTable() {
  var tableInfo = new Array();
  var tableObj = document.getElementById("input_tb_id");
  for (var i = 1; i < tableObj.rows.length; i++) { //遍历Table的所有Row
    var rowInfo = new Array();
    for (var j = 0; j < tableObj.rows[i].cells.length; j++) { //遍历Row中的每一列
      var child = tableObj.rows[i].cells[j].children[0]; //获取Table中单元格的内容
      if (child.tagName == "INPUT") {
        if (child.value == null || child.value == "") {
          break;
        }
        rowInfo[j] = child.value;
      }
    }
    if (rowInfo.length == 4) {
      tableInfo[i] = rowInfo;
    }
  }
  console.log('tableInfo--' + tableInfo);
  return tableInfo;
}

//清空页面
function clearInfo() {
  location.reload();
}

//上传图片到服务器
function submitInfo() {
  var waybill = $("#waybillcode_input").val();
  if (!waybill) {
    alert("运单号不能为空");
    return;
  }
  var oWeight = $("#open_weight").val();
  var oVolume = $("#open_volume").val();
  var oCount = $("#open_count").val();
  var fWeight = $("#fact_weight").val();
  if (!fWeight) {
    fWeight = 0;
  }
  var tableInfo = GetInfoFromTable();
  var totalVolume = 0;
  var totalCount = 0;
  var volume = 0;
  for (var i = 0; i < tableInfo.length; i++) {
    var rowInfo = tableInfo[i];
    if (rowInfo instanceof Array) {
      volume = 1;
      for (var j = 0; j < rowInfo.length; j++) {
        volume *= Number(rowInfo[j]);
        if (j == rowInfo.length - 1) {
          totalCount += Number(rowInfo[j]);
        }
      }
      totalVolume += volume;
    }
  }
  var fVolume = Math.round((totalVolume / 1000) * 100) / 100;
  //  alert("fVolume=" + fVolume+"totalVolume=" + totalVolume + "totalCount=" + totalCount);
  if (fWeight <= 0 && fVolume <= 0) {
    alert("请录入实际重量或长宽高件数信息!");
    return;
  }
  if (fVolume <= 0) {
    totalCount = oCount;
  } else {
    if (totalCount != oCount) {
      alert("实际件数和开单件数不一致，请联系值班人员反馈异常!");
      return;
    }
  }
  if (fVolume <= 0) {
    fVolume = oVolume;
  }
  if (fWeight <= 0) {
    fWeight = oWeight;
  }
  if (fWeight > 999999.99) {
    alert("实际重量的输入范围为：0.01~999999.99");
    return;
  }
  if (fVolume > 999999.99) {
    alert("实际体积的输入范围为：0.01~999999.99");
    return;
  }
  var imgList = document.getElementsByClassName("addImg");
  var imgPathList = new Array();
  for (var i = 0; i < imgList.length; i++) {
    imgPathList.push(imgList[i].src);
  }
  console.log('imgpathList.length');
  if (imgPathList.length == 0) {
    alert("上传照片不能为空");
    return;
  }
  $("#loading").show();
  $.ajax({
    type: "post",
    url: "http://",
    timeout: 10000,
    data: {
//      'count': totalCount,
//      'volumeList': tableInfo,
//      'jobnum': user.jobnum,
//      'username': user.username,
//      'deptid': user.deptid,
//      'imgpathList': imgPathList
    },
    dataType: "json",
    contentType: 'application/json;charset=utf-8',
    success: function(data) {
      $("#loading").hide();
      alert("提交成功");
      alert("执行结果" + data.returnmsg);
    },
    error: function(XMLHttpRequest, textStatus, errorThrown) {
      $("#loading").hide();
      console.log("XMLHttpRequest.status==" + XMLHttpRequest.status);
      console.log("XMLHttpRequest.readyState==" + XMLHttpRequest.readyState);
      console.log("errorThrown" + errorThrown);
      if (textStatus == "error" || textStatus == null) {
      alert("链接错误");
      } else if (textStatus == "timeout") {
       alert("连接超时");
      } else if (textStatus == "parsererror") {
       alert("解析错误");
      } else {
        alert("提交失败");
      }
    }
  });
}