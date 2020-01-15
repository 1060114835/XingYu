## 框架文档
整个项目采用MVVM，使用google内置的databing、viewmodel、lifecycle  
MVVM 分为三层
- V层，view，负责视图
- M层，model，数据
- VM层，viewModel  
在此基础上，为了使结构更清晰，在V层和VM层之间加了一个presenter层，用来专门处理点击事件
### 目录
- common 框架的base层以及一些全局通用的类，比如标题栏，ToastUtil工具类等
- model mvvm的m层，存放Bean数据
- presenter 专门用于处理点击事件
- utils 通用的工具类放在这里
- view mvvm的v层，存放aitivity和fragment
- viewmodel mvvm的vm层，用于从网络或者本地请求数据，并将数据加载到xml页面
### 简要
- 已经对单类型的recyclerview做了封装，在Test类里面有写，使用时只需
```java
public class TestViewModel extends AdapterViewModel {
    ...
    @Override
    public BaseAdapter getAdapter(Context context) {
        if (singleTypeAdapter == null) {
            singleTypeAdapter =  new SingleTypeAdapter<>(context,com.meet.xingyu.BR.data
                    , R.layout.item_test, com.meet.xingyu.BR.presenter);
            singleTypeAdapter.set(mList);
            singleTypeAdapter.setmListener(TestPresenter.getInstance());
        }
        return singleTypeAdapter;
    }

    @Override
    public LinearLayoutManager getLayoutManager(Context context) {
        return new LinearLayoutManager(context);
    }
    ...
}
```

```java
public class TestPresenter extends ItemPresenter<MutableLiveData<TestBean>> {

    ...

    @Override
    public void onItemClick(View view, MutableLiveData<TestBean> bean) {
        ToastUtil.getInstance().toast(bean.getValue().getUserName());
    }
}
```


- 弹消息统一使用
```
ToastUtil.getInstance().toast("msg");
```
- 打印日志统一使用

```
LogUtil.d(String tag, String msg);
```
- 对所有viewmodel和presneter使用单例
- xml中的数据全部通过viewmodel绑定
- 标题栏：在avtivity中覆写init方法，然后
```java
@Override
    protected void init() {
        CustomActionBar.set(this, TestPresenter.getInstance(), TestViewModel.getInstance().getTitle());

    }
```

## 项目规范
- 每次动手写代码前先拉一遍最新代码
- 每次提交代码时先拉一遍代码处理冲突
- Java文件命名
类似于这样，自己写的页面的名称+类型  

```
LoginViewModel
LoginPresenter
...
```

- 工具类统一以Util结尾
- 全局常量统一写在在utils包下的Constants常量类中，并写好注释
- 布局中引用的dp、sp还有颜色统一在values文件夹中定义。每次使用资源时先在values包内看看有没有其他人已经写好使用过的
- xml文件命名
类型+下划线+自己写的页面，例如  

```xml
activity_login
fragment_login
item_detail
```




