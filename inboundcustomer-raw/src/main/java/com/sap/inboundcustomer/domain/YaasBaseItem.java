package com.sap.inboundcustomer.domain;

import java.util.List;
import java.util.Map;

public abstract class YaasBaseItem {
    abstract public List<Map<String, String>> createRawFragments();

    abstract public Map<String, String> createRawFragment();
}