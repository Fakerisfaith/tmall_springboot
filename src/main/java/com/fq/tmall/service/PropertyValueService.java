	

package com.fq.tmall.service;

import java.util.List;

import com.fq.tmall.dao.PropertyValueDAO;
import com.fq.tmall.pojo.Product;
import com.fq.tmall.pojo.Property;
import com.fq.tmall.pojo.PropertyValue;
import com.fq.tmall.util.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PropertyValueService  {

	@Autowired
	PropertyValueDAO propertyValueDAO;
	@Autowired PropertyService propertyService;


	public void update(PropertyValue bean) {
		propertyValueDAO.save(bean);
	}

	public void init(Product product) {
		PropertyValueService propertyValueService = SpringContextUtil.getBean(PropertyValueService.class);

		List<Property> propertys= propertyService.listByCategory(product.getCategory());
		for (Property property: propertys) {
			PropertyValue propertyValue = propertyValueService.getByPropertyAndProduct(product, property);
			if(null==propertyValue){
				propertyValue = new PropertyValue();
				propertyValue.setProduct(product);
				propertyValue.setProperty(property);
				propertyValueDAO.save(propertyValue);
			}
		}
	}
	//

	public PropertyValue getByPropertyAndProduct(Product product, Property property) {
		return propertyValueDAO.getByPropertyAndProduct(property,product);
	}


	public List<PropertyValue> list(Product product) {
		return propertyValueDAO.findByProductOrderByIdDesc(product);
	}
	
	
	
}
