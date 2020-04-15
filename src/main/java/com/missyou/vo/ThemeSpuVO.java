package com.missyou.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ThemeSpuVO extends ThemePureVO {

    private List<SpuSimplifyVO> spuList;
}
