package com.inm429.ecommerce.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "count")
public class Count {
	@Id
	@Column(name = "count")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int count;
}
