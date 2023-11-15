<template>
    <br/>
    <h4>😭 SSAFIT을 사용해 주셔서 감사합니다 😭</h4>
    <div class="container px-4 text-center">
        <div class="row gx-5">
            <div class="col">
            <div class="p-3">
                <h3 style="align-self: center;"> 🧑 조용운 </h3>
                <h5> 10기 서울 5반</h5>
                <img src="@/assets/cat.png" width="20%"/>
                <p></p>
                <p class="emailfont"><i class="bi bi-mailbox"></i> cyy8071@naver.com</p>
                <a class="gitfont" href="https://github.com/chomchom96"><i class="bi bi-github"></i> GITHUB</a>
                <p></p>
                <p class="phonefont"> <i class="bi bi-phone"></i> 010-5040-8071 </p>
                <p> </p>
            </div>
            
            </div>
            <div class="col">
            <div class="p-3">
                <h3 style="align-self: center;"> 🤢 백천주 </h3>
                <h5> 10기 서울 5반</h5>
                <img src="@/assets/coder.png" width="20%"/>
                <p></p>
                <p class="emailfont"><i class="bi bi-mailbox"></i> kakapokachip@gmail.com</p>
                <a class="gitfont" href="https://github.com/lookoblong"><i class="bi bi-github"></i> GITHUB</a>
                <p></p>
                <p class="phonefont"> <i class="bi bi-phone"></i> 010-9918-8441 </p>
                <p> </p>
            </div>
            </div>
        </div>
    </div>

    <div class=contact>
        <h2> Contact US </h2>
        <br>
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">메일 주소</label>
            <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
        </div>
        <div class="mb-3">
            <label for="exampleFormControlTextarea1" class="form-label">문의 내용</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
        </div>
        <button class="btn">전송</button>
    </div>
    
</template>

<script setup>

</script>

<style scoped>

h4 {
    margin-left: 50px;
    text-align: center;
}

.intro {
    text-align: center;
}

.row {
    background-color: #f8f9fa;
    border-radius: 10px;
    padding: 20px;
}

.p-3 {
    color: #666;
    background-color: #ffffff;
    border-radius: 20px;
    padding: 20px;
    margin-bottom: 20px;
    border: 0.5px solid rgba(102, 102, 102, 0.35);

    
}

.contact {
    text-align: center;
    margin: 50px auto;
    max-width: 700px;
}


.contact {
    text-align: center;
}

.btn {
  padding: 10px;
  background-color: #333; /* 무채색 배경 */
  color: #fff; /* 흰색 텍스트 */
  border: none;
  cursor: pointer;
  margin-right: 10px;
  
}

.btn:hover {
  background-color: #555; /* 호버 시 어둡게 변하는 배경 */
}

h2, h4 {
    text-align: center;
    color: #333;
    font-family: Poppins;
    font-size: 32px;
    font-style: normal;
    font-weight: 500;
    line-height: normal;
  }

.emailfont {
    color: #666;
    font-family: Poppins;
    font-size: 24px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
}

.gitfont {
    font-size: 17px;
}

.phonefont {
    font-size: 15px;

}

</style>