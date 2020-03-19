package com.cwd.tg.gss.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class CharacterProgressInfo implements Serializable {
    private long currentExp;
    private int level;
    private long targetExp;
}
