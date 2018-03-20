
package android.databinding;
import com.example.nikul.myapplication.BR;
class DataBinderMapper  {
    final static int TARGET_MIN_SDK = 18;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.example.nikul.myapplication.R.layout.activity_homework3:
                    return com.example.nikul.myapplication.databinding.ActivityHomework3Binding.bind(view, bindingComponent);
                case com.example.nikul.myapplication.R.layout.activity_classwork9:
                    return com.example.nikul.myapplication.databinding.ActivityClasswork9Binding.bind(view, bindingComponent);
                case com.example.nikul.myapplication.R.layout.activity_homework9:
                    return com.example.nikul.myapplication.databinding.ActivityHomework9Binding.bind(view, bindingComponent);
                case com.example.nikul.myapplication.R.layout.activity_classwork10:
                    return com.example.nikul.myapplication.databinding.ActivityClasswork10Binding.bind(view, bindingComponent);
        }
        return null;
    }
    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case -409417399: {
                if(tag.equals("layout/activity_homework3_0")) {
                    return com.example.nikul.myapplication.R.layout.activity_homework3;
                }
                break;
            }
            case -776929652: {
                if(tag.equals("layout/activity_classwork9_0")) {
                    return com.example.nikul.myapplication.R.layout.activity_classwork9;
                }
                break;
            }
            case -409411633: {
                if(tag.equals("layout/activity_homework9_0")) {
                    return com.example.nikul.myapplication.R.layout.activity_homework9;
                }
                break;
            }
            case 1684702574: {
                if(tag.equals("layout/activity_classwork10_0")) {
                    return com.example.nikul.myapplication.R.layout.activity_classwork10;
                }
                break;
            }
        }
        return 0;
    }
    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"hw3ViewModel"
            ,"myEntity"
            ,"myUser"
            ,"name"
            ,"viewModel"};
    }
}