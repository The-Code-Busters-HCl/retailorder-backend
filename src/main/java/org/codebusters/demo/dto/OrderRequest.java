package org.codebusters.demo.dto;

import java.util.List;

public record OrderRequest(
        List<Long> productIds,
        List<Integer> quantities
) {}