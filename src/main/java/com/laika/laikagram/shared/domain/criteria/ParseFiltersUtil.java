package com.laika.laikagram.shared.domain.criteria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ParseFiltersUtil {
    public static List<HashMap<String, String>> parse(List<HashMap<String, Serializable>> params) {

        if (params.isEmpty()) {
            return new ArrayList<>();
        }

        List<HashMap<String, String>> filters = new ArrayList<>();

        for (HashMap<String, Serializable> param : params){
            filters.add(new HashMap<>() {{
                put("field", (String) param.get("field"));
                put("operator", (String) param.get("operator"));
                put("value", (String) param.get("value"));
            }});
        }

        return filters;
    }

}
