
package android.databinding;
import com.example.nikul.myapplication.BR;
class DataBinderMapper  {
    final static int TARGET_MIN_SDK = 18;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.example.nikul.myapplication.R.layout.item_userrecycler:
                    return com.example.nikul.myapplication.databinding.ItemUserrecyclerBinding.bind(view, bindingComponent);
                case com.example.nikul.myapplication.R.layout.activity_homework1:
                    return com.example.nikul.myapplication.databinding.ActivityHomework1Binding.bind(view, bindingComponent);
                case com.example.nikul.myapplication.R.layout.activity_homework3:
                    return com.example.nikul.myapplication.databinding.ActivityHomework3Binding.bind(view, bindingComponent);
                case com.example.nikul.myapplication.R.layout.activity_homework2:
                    return com.example.nikul.myapplication.databinding.ActivityHomework2Binding.bind(view, bindingComponent);
                case com.example.nikul.myapplication.R.layout.activity_homework5:
                    return com.example.nikul.myapplication.databinding.ActivityHomework5Binding.bind(view, bindingComponent);
                case com.example.nikul.myapplication.R.layout.activity_homework4:
                    return com.example.nikul.myapplication.databinding.ActivityHomework4Binding.bind(view, bindingComponent);
                case com.example.nikul.myapplication.R.layout.activity_classwork9:
                    return com.example.nikul.myapplication.databinding.ActivityClasswork9Binding.bind(view, bindingComponent);
                case com.example.nikul.myapplication.R.layout.activity_clock:
                    return com.example.nikul.myapplication.databinding.ActivityClockBinding.bind(view, bindingComponent);
                case com.example.nikul.myapplication.R.layout.activity_homework9:
                    return com.example.nikul.myapplication.databinding.ActivityHomework9Binding.bind(view, bindingComponent);
                case com.example.nikul.myapplication.R.layout.activity_classwork10:
                    return com.example.nikul.myapplication.databinding.ActivityClasswork10Binding.bind(view, bindingComponent);
                case com.example.nikul.myapplication.R.layout.activity_owl:
                    return com.example.nikul.myapplication.databinding.ActivityOwlBinding.bind(view, bindingComponent);
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
            case 1522133634: {
                if(tag.equals("layout/item_userrecycler_0")) {
                    return com.example.nikul.myapplication.R.layout.item_userrecycler;
                }
                break;
            }
            case -409419321: {
                if(tag.equals("layout/activity_homework1_0")) {
                    return com.example.nikul.myapplication.R.layout.activity_homework1;
                }
                break;
            }
            case -409417399: {
                if(tag.equals("layout/activity_homework3_0")) {
                    return com.example.nikul.myapplication.R.layout.activity_homework3;
                }
                break;
            }
            case -409418360: {
                if(tag.equals("layout/activity_homework2_0")) {
                    return com.example.nikul.myapplication.R.layout.activity_homework2;
                }
                break;
            }
            case -409415477: {
                if(tag.equals("layout/activity_homework5_0")) {
                    return com.example.nikul.myapplication.R.layout.activity_homework5;
                }
                break;
            }
            case -409416438: {
                if(tag.equals("layout/activity_homework4_0")) {
                    return com.example.nikul.myapplication.R.layout.activity_homework4;
                }
                break;
            }
            case -776929652: {
                if(tag.equals("layout/activity_classwork9_0")) {
                    return com.example.nikul.myapplication.R.layout.activity_classwork9;
                }
                break;
            }
            case 286488404: {
                if(tag.equals("layout/activity_clock_0")) {
                    return com.example.nikul.myapplication.R.layout.activity_clock;
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
            case -1646393718: {
                if(tag.equals("layout/activity_owl_0")) {
                    return com.example.nikul.myapplication.R.layout.activity_owl;
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
            ,"myEntity"
            ,"myUser"
            ,"name"
            ,"viewModel"};
    }
}