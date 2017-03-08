/*
 * jPOS Project [http://jpos.org]
 * Copyright (C) 2000-2017 jPOS Software SRL
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.jpos.qi.system;

import com.vaadin.v7.data.Container;
import com.vaadin.v7.data.fieldgroup.BeanFieldGroup;
import com.vaadin.v7.data.fieldgroup.FieldGroup;
import org.hibernate.criterion.Restrictions;
import org.jpos.ee.BLException;
import org.jpos.ee.SysLog;
import org.jpos.qi.EntityContainer;
import org.jpos.qi.QIHelper;

import java.util.*;

/**
 * Created by jr on 6/16/16.
 */
public class AuditLogHelper extends QIHelper {

    protected AuditLogHelper() {
        super(SysLog.class);
    }


    public Container createContainer() {
        Map<String, Class> properties = new LinkedHashMap<>();
        properties.put("id", Integer.class);
        properties.put("date", Date.class);
        properties.put("deleted", Boolean.class);
        properties.put("source", String.class);
        properties.put("type", String.class);
        properties.put("severity", Integer.class);
        properties.put("summary", String.class);
        properties.put("detail", String.class);
        properties.put("trace", String.class);

        List sortable = Arrays.asList("id", "date", "deleted", "source", "type","severity","summary");
        EntityContainer container = new EntityContainer<>(SysLog.class, properties, sortable);
        container.addRestriction(Restrictions.eq("deleted",false));
        return container;
    }

    @Override
    public boolean updateEntity(BeanFieldGroup fieldGroup) throws FieldGroup.CommitException, BLException, CloneNotSupportedException {
        return false;
    }
}
