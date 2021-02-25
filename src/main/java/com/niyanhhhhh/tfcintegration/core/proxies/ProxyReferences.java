package com.niyanhhhhh.tfcintegration.core.proxies;

import com.niyanhhhhh.tfcintegration.botania.ProxyBotania;

import java.util.HashMap;
import java.util.Map;

public class ProxyReferences {

    public static final Map<String, CommonProxy> proxies = new HashMap<>();

    public static final CommonProxy PROXY_BOTANIA = new ProxyBotania();

}
