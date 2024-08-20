// 动态生成html元素
function generateNode(obj) {
    let { labelConfig, inputConfig, errorConfig } = obj;
    let formItem = document.createElement("div");
    let formItemContent = document.createElement("div");
    formItem.classList.add("el-form-item");
    formItemContent.classList.add("el-form-item__content");

    if (labelConfig) {
        let formItemLabel = document.createElement("label");
        formItemLabel.classList.add("el-form-item__label");
        let { innerText, forName } = labelConfig
        innerText ? formItemLabel.innerText = innerText : null;
        forName ? formItemLabel.for = forName : null;
        formItem.appendChild(formItemLabel)
    }
    if (inputConfig) {
        let formInput = document.createElement("div");
        let inputEl = document.createElement("input");
        inputEl.classList.add("el-input__inner");
        formInput.classList.add("el-input");

        let { type, name, id, value } = obj.inputConfig;
        id ? inputEl.id = id : null;
        name ? inputEl.name = name : null;
        type ? inputEl.type = type : null;
        value ? inputEl.value = value : null;

        formInput.appendChild(inputEl);
        formItemContent.appendChild(formInput);
    }
    // 创建校验错误信息
    if (errorConfig) {
        let errorEl = document.createElement("div");
        errorEl.classList.add("el-form-item__error");
        let {msg} = errorConfig;
        errorEl.innerText = msg;
        formItemContent.appendChild(errorEl);
    }
    formItem.appendChild(formItemContent);

    return formItem;
}
let formObjList = [
    {
        labelConfig: {
            innerText: "用户名：",
            forName: "username"
        },
        inputConfig: {
            type: "text",
            name: "username",
            id: "username"
        },
        errorConfig: {
            msg: "用户名不能为空"
        }
    },
    {
        labelConfig: {
            innerText: "密码：",
            forName: "password"
        },
        inputConfig: {
            type: "password",
            name: "password",
            id: "password"
        },
        errorConfig: {
            msg: "密码不能为空"
        }
    },
    {
        inputConfig: {
            type: "submit",
            value: "提交"
        }
    }
]
let formEl = document.getElementsByClassName("el-form")[0];
//console.log(formEl);
formObjList.forEach(item => {
    formEl.appendChild(generateNode(item));
})