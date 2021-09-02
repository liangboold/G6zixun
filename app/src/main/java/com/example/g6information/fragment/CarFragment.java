package com.example.g6information.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.alipay.sdk.app.AuthTask;
import com.alipay.sdk.app.EnvUtils;
import com.alipay.sdk.app.PayTask;
import com.example.g6information.AuthResult;
import com.example.g6information.H5PayDemoActivity;
import com.example.g6information.PayResult;
import com.example.g6information.R;
import com.example.g6information.activity.MainActivity;

import com.example.g6information.adarpter.Caradarpter;
import com.example.g6information.entily.Userentily;
import com.example.g6information.util.OrderInfoUtil2_0;

import java.util.List;
import java.util.Map;


public class CarFragment extends Fragment {
    private RecyclerView crv;
    Caradarpter caradarpter;
    private Button btnJie;
    List<Userentily> userentilies;

    /**
     * 用于支付宝支付业务的入参 app_id。
     */
    public static final String APPID = "2021000117668358";

    /**
     * 用于支付宝账户登录授权业务的入参 pid。
     */
    public static final String PID = "";

    /**
     * 用于支付宝账户登录授权业务的入参 target_id。
     */
    public static final String TARGET_ID = "";

    /**
     *  pkcs8 格式的商户私钥。
     *
     * 	如下私钥，RSA2_PRIVATE 或者 RSA_PRIVATE 只需要填入一个，如果两个都设置了，本 Demo 将优先
     * 	使用 RSA2_PRIVATE。RSA2_PRIVATE 可以保证商户交易在更加安全的环境下进行，建议商户使用
     * 	RSA2_PRIVATE。
     *
     * 	建议使用支付宝提供的公私钥生成工具生成和获取 RSA2_PRIVATE。
     * 	工具地址：https://doc.open.alipay.com/docs/doc.htm?treeId=291&articleId=106097&docType=1
     */
    public static final String RSA2_PRIVATE = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCzKkq1S5xDDXawZLunn4Rznn6LcGlsLwYD1HmqueIVx3w6DEx/Jm20D/oJJAoPBWBXlWaxAIMTg/YQwaE2ZLUejNDr30lE8gZKYpH85X4HYfPpdniAWkFc34iyecT9rSiEbDZOLzVZMP/KsRwXNR4mQSiOPQ7eBH5hpY/2o5gDv4a1J9zLct8DBTZ1Oz42U/EI3zHlmJaVMEZl/nP+H2pEPXforBbSP5rGvxDIg9hARC7+LiKsuYthHahWmPg6tqTr3EzENhnwlCW9W5BEipeTNh4ltpiWqvernFoGqlyrPjCH8gKA+ABsJxXIYBLG4dWoXcAv5sUs+XjtveXFUDz5AgMBAAECggEASLrmUOo8qMuSXtDFjKoornaskBY19YCxRGTAbxm+OXEdcMMFWqhS6EGEEqnam3ZnQaaYZUn767Qp82tm8hm3nIs1VEr0B1ToUNHqyWqv2ndc+GzrRc9dsUHcz/a2jPP5+qei8+IeGfLWI4X6DUG213ij6fnHS0EvvJvk8Q4/62TnuyTvQW6b1bym8N2EdIDbpgeBTE+5RCqX3SM8r6zFGhIn8nR/NBE2NWMdo4hgY4dhIv9DszDm/4LTDJxsjBS384M0qqdLbjqL+LJpl8pgDzdNJUKTKkvAXSXnznQqEnvNLI/Aj0gBwLRAodPQlyS5NsNmJFcQtzNi1P660BNjMQKBgQD/3crDPTGCsUaOKT2miz8usKUUOROfUYCGnRWsPU4l8nxxmPRrsq+2SRg6bPjCpj88LTekWN3Xeq/+jlP4RHsK5OyvBEOUy2Y53M4vqdS6Gmp3AhIbVdCRxTF6f0tNteKYCLo/F0Spn7rDD9poY/MK676v5cqtBrdUX23EihBQkwKBgQCzQj7I5TnN5rySiP5ZfJxIVzInpQrb5hQ/WEGjHumftPN3WhsI60m9tLgDcWLwiUc4//6M7ikf3KJe2Ml5DEaSNhhMhF1PoPvwirITQX1mrM1hqJdcJKZpDDF5hpA0p1HSiXxhin0sTFiaaJK6o7MW/ceftRoBdO6Peo1okNTPwwKBgQDEp/CG/QqHu79R1orG7bGDLkvC7leRlS/mxud4eaoN6oERQpFiEXWR8j5H8aeE3AgwNUTV8WOYkXihez04zVGQvwDXR7y1qVuJz5c99RdGbrUzgQjvr5Zd46Uy1JHJSam+Vr7nbPfeM6F0+UNSBrgvxZ/LTB/puwa/N5WDgOYnNwKBgD1fgut5P881Hn71FFBDD6bc47kbEpqzLV96sg5NOSOK6oiEexkUpYyj4RScr4k3FwF29AoASGg2PAlJI8Gj6E2K48rezqvCrD9w3QMmuu56X17+P8Q2cBsrJ405+wlr9+GjXMhwh+awxO0ovIPWJCzM+pm9gYfaJwtMpDmWzKXNAoGBALRx9oxPXP3uBBO0US6OhnqP8E3lfcvT8eh+TvaL2e4/8lLqGIAizl8NCo0vfpmGmTiqJ1N1cZjkmMzIDdPA4Yih56/xZ/0JvcAGlGb3oR2xkN8PJlrE6f7LwWXoQrFVBw+/912L+IjTqm4b8k6nimE3KqJY9mor+qc53v4XMae1";
    public static final String RSA_PRIVATE = "";

    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     * 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        showAlert(getActivity(), getString(R.string.pay_success) + payResult);
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        showAlert(getActivity(), getString(R.string.pay_failed) + payResult);
                    }
                    break;
                }
                case SDK_AUTH_FLAG: {
                    @SuppressWarnings("unchecked")
                    AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
                    String resultStatus = authResult.getResultStatus();

                    // 判断resultStatus 为“9000”且result_code
                    // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                    if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                        // 获取alipay_open_id，调支付时作为参数extern_token 的value
                        // 传入，则支付账户为该授权账户
                        showAlert(getActivity(), getString(R.string.auth_success) + authResult);
                    } else {
                        // 其他状态值则为授权失败
                        showAlert(getActivity(), getString(R.string.auth_failed) + authResult);
                    }
                    break;
                }
                default:
                    break;
            }
        };
    };

    @Override
    public void onResume() {
        super.onResume();
        userentilies = MainActivity.userentilyDao.loadAll();
        caradarpter = new Caradarpter(userentilies);
        crv.setAdapter(caradarpter);
        crv.setLayoutManager(new LinearLayoutManager(getContext()));
        caradarpter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_car, container, false);
        crv = (RecyclerView) inflate.findViewById(R.id.crv);
        btnJie = (Button) inflate.findViewById(R.id.btn_jie);
        btnJie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnvUtils.setEnv(EnvUtils.EnvEnum.SANDBOX);
                payV2(btnJie);
                MainActivity.userentilyDao.deleteAll();
            }
        });
        return inflate;
    }
    /**
     * 支付宝支付业务示例
     */
    public void payV2(View v) {
        if (TextUtils.isEmpty(APPID) || (TextUtils.isEmpty(RSA2_PRIVATE) && TextUtils.isEmpty(RSA_PRIVATE))) {
            showAlert(getActivity(), getString(R.string.error_missing_appid_rsa_private));
            return;
        }

        /*
         * 这里只是为了方便直接向商户展示支付宝的整个支付流程；所以Demo中加签过程直接放在客户端完成；
         * 真实App里，privateKey等数据严禁放在客户端，加签过程务必要放在服务端完成；
         * 防止商户私密数据泄露，造成不必要的资金损失，及面临各种安全风险；
         *
         * orderInfo 的获取必须来自服务端；
         */
        boolean rsa2 = (RSA2_PRIVATE.length() > 0);
        Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(APPID, rsa2);
        String orderParam = OrderInfoUtil2_0.buildOrderParam(params);

        String privateKey = rsa2 ? RSA2_PRIVATE : RSA_PRIVATE;
        String sign = OrderInfoUtil2_0.getSign(params, privateKey, rsa2);
        final String orderInfo = orderParam + "&" + sign;

        final Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(getActivity());
                Map<String, String> result = alipay.payV2(orderInfo, true);
                Log.i("msp", result.toString());

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    /**
     * 支付宝账户授权业务示例
     */
    public void authV2(View v) {
        if (TextUtils.isEmpty(PID) || TextUtils.isEmpty(APPID)
                || (TextUtils.isEmpty(RSA2_PRIVATE) && TextUtils.isEmpty(RSA_PRIVATE))
                || TextUtils.isEmpty(TARGET_ID)) {
            showAlert(getActivity(), getString(R.string.error_auth_missing_partner_appid_rsa_private_target_id));
            return;
        }

        /*
         * 这里只是为了方便直接向商户展示支付宝的整个支付流程；所以Demo中加签过程直接放在客户端完成；
         * 真实App里，privateKey等数据严禁放在客户端，加签过程务必要放在服务端完成；
         * 防止商户私密数据泄露，造成不必要的资金损失，及面临各种安全风险；
         *
         * authInfo 的获取必须来自服务端；
         */
        boolean rsa2 = (RSA2_PRIVATE.length() > 0);
        Map<String, String> authInfoMap = OrderInfoUtil2_0.buildAuthInfoMap(PID, APPID, TARGET_ID, rsa2);
        String info = OrderInfoUtil2_0.buildOrderParam(authInfoMap);

        String privateKey = rsa2 ? RSA2_PRIVATE : RSA_PRIVATE;
        String sign = OrderInfoUtil2_0.getSign(authInfoMap, privateKey, rsa2);
        final String authInfo = info + "&" + sign;
        Runnable authRunnable = new Runnable() {

            @Override
            public void run() {
                // 构造AuthTask 对象
                AuthTask authTask = new AuthTask(getActivity());
                // 调用授权接口，获取授权结果
                Map<String, String> result = authTask.authV2(authInfo, true);

                Message msg = new Message();
                msg.what = SDK_AUTH_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        // 必须异步调用
        Thread authThread = new Thread(authRunnable);
        authThread.start();
    }

    /**
     * 获取支付宝 SDK 版本号。
     */
    public void showSdkVersion(View v) {
        PayTask payTask = new PayTask(getActivity());
        String version = payTask.getVersion();
        showAlert(getActivity(), getString(R.string.alipay_sdk_version_is) + version);
    }

    /**
     * 将 H5 网页版支付转换成支付宝 App 支付的示例
     */
    public void h5Pay(View v) {
        WebView.setWebContentsDebuggingEnabled(true);
        Intent intent = new Intent(getActivity(), H5PayDemoActivity.class);
        Bundle extras = new Bundle();

        /*
         * URL 是要测试的网站，在 Demo App 中会使用 H5PayDemoActivity 内的 WebView 打开。
         *
         * 可以填写任一支持支付宝支付的网站（如淘宝或一号店），在网站中下订单并唤起支付宝；
         * 或者直接填写由支付宝文档提供的“网站 Demo”生成的订单地址
         * （如 https://mclient.alipay.com/h5Continue.htm?h5_route_token=303ff0894cd4dccf591b089761dexxxx）
         * 进行测试。
         *
         * H5PayDemoActivity 中的 MyWebViewClient.shouldOverrideUrlLoading() 实现了拦截 URL 唤起支付宝，
         * 可以参考它实现自定义的 URL 拦截逻辑。
         */
        String url = "https://m.taobao.com";
        extras.putString("url", url);
        intent.putExtras(extras);
        startActivity(intent);
    }

    private static void showAlert(Context ctx, String info) {
        showAlert(ctx, info, null);
    }

    private static void showAlert(Context ctx, String info, DialogInterface.OnDismissListener onDismiss) {
        new AlertDialog.Builder(ctx)
                .setMessage(info)
                .setPositiveButton(R.string.confirm, null)
                .setOnDismissListener(onDismiss)
                .show();
    }

    private static void showToast(Context ctx, String msg) {
        Toast.makeText(ctx, msg, Toast.LENGTH_LONG).show();
    }

    private static String bundleToString(Bundle bundle) {
        if (bundle == null) {
            return "null";
        }
        final StringBuilder sb = new StringBuilder();
        for (String key: bundle.keySet()) {
            sb.append(key).append("=>").append(bundle.get(key)).append("\n");
        }
        return sb.toString();
    }
}