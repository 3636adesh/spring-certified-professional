package com.common.enititable;

import lombok.Getter;
import lombok.Setter;

/**
 * A base class for all entities that use a internal long identifier for
 * tracking entity identity.
 */
@Getter
@Setter
public class Entity {

    private Long entityId;


}
