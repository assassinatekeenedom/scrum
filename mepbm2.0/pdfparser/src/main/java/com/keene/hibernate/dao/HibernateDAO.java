package com.keene.hibernate.dao;

import com.keene.dao.DAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class HibernateDAO<H extends HibernateModel> extends HibernateDaoSupport implements DAO<H> {

    @Override
    public abstract List<H> selectAll();

    @Override
    public List<H> select(Properties props, H model) {
        Query query = this.buildQuery(props, model);
        if (query != null) {
            return query.list();
        }
        return new ArrayList<H>();
    }

    @Override
    public H save(H hibernateModel) {
        try {
            getHibernateTemplate().saveOrUpdate(hibernateModel);
        } catch (Exception e) {
            this.getSession().merge(hibernateModel);
            getHibernateTemplate().saveOrUpdate(hibernateModel);
        }
        return hibernateModel;
    }

    @Override
    public H load(Properties props, H model) {
        H unique = this.selectUnique(props, model);
        if (unique != null) {
            return unique;
        }
        return this.save(model);
    }

    @Override
    public H selectUnique(Properties props, H model) {
        Query query = this.buildQuery(props, model);
        if (query != null) {
            return (H) query.uniqueResult();
        }
        return null;
    }

    private Query buildQuery(Properties props, H model) {
        StringBuilder sql = new StringBuilder();
        sql.append("from ");
        sql.append(model.getClass().getSimpleName());
        if (props.size() > 0) {
            sql.append(" where ");
            boolean first = true;
            for (Object key : props.keySet()) {
                if (!first) {
                    sql.append(" and ");
                } else {
                    first = false;
                }
                sql.append(key);
                sql.append("= :");
                sql.append(key);
            }
        }
        Query query = null;
        try {
            query = this.getSession().createQuery(sql.toString());
            for (Object key : props.keySet()) {
                query.setParameter((String) key, props.get(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return query;
    }
}
