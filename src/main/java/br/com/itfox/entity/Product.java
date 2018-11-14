/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author belchiorpalma
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductId", query = "SELECT p FROM Product p WHERE p.productId = :productId"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
    @NamedQuery(name = "Product.findByDescription", query = "SELECT p FROM Product p WHERE p.description = :description"),
    @NamedQuery(name = "Product.findByMetaTagTitle", query = "SELECT p FROM Product p WHERE p.metaTagTitle = :metaTagTitle"),
    @NamedQuery(name = "Product.findByMetaTagDescription", query = "SELECT p FROM Product p WHERE p.metaTagDescription = :metaTagDescription"),
    @NamedQuery(name = "Product.findByMetaTagKeywords", query = "SELECT p FROM Product p WHERE p.metaTagKeywords = :metaTagKeywords"),
    @NamedQuery(name = "Product.findByPic1", query = "SELECT p FROM Product p WHERE p.pic1 = :pic1"),
    @NamedQuery(name = "Product.findByPic2", query = "SELECT p FROM Product p WHERE p.pic2 = :pic2"),
    @NamedQuery(name = "Product.findByPic3", query = "SELECT p FROM Product p WHERE p.pic3 = :pic3"),
    @NamedQuery(name = "Product.findByPic4", query = "SELECT p FROM Product p WHERE p.pic4 = :pic4"),
    @NamedQuery(name = "Product.findByPic5", query = "SELECT p FROM Product p WHERE p.pic5 = :pic5"),
    @NamedQuery(name = "Product.findByCategoryId", query = "SELECT p FROM Product p WHERE p.categoryId = :categoryId"),
    @NamedQuery(name = "Product.findByVarietal", query = "SELECT p FROM Product p WHERE p.varietal = :varietal"),
    @NamedQuery(name = "Product.findByAlcohool", query = "SELECT p FROM Product p WHERE p.alcohool = :alcohool"),
    @NamedQuery(name = "Product.findByRegion", query = "SELECT p FROM Product p WHERE p.region = :region"),
    @NamedQuery(name = "Product.findByYear", query = "SELECT p FROM Product p WHERE p.year = :year"),
    @NamedQuery(name = "Product.findByMevushal", query = "SELECT p FROM Product p WHERE p.mevushal = :mevushal"),
    @NamedQuery(name = "Product.findByBrand", query = "SELECT p FROM Product p WHERE p.brand = :brand"),
    @NamedQuery(name = "Product.findByQuantityInStock", query = "SELECT p FROM Product p WHERE p.quantityInStock = :quantityInStock"),
    @NamedQuery(name = "Product.findByBuyPrice", query = "SELECT p FROM Product p WHERE p.buyPrice = :buyPrice")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "product_id")
    private Integer productId;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "price")
    private String price;
    @Size(max = 4000)
    @Column(name = "description")
    private String description;
    @Size(max = 4000)
    @Column(name = "meta_tag_title")
    private String metaTagTitle;
    @Size(max = 4000)
    @Column(name = "meta_tag_description")
    private String metaTagDescription;
    @Size(max = 4000)
    @Column(name = "meta_tag_keywords")
    private String metaTagKeywords;
    @Size(max = 4000)
    @Column(name = "pic1")
    private String pic1;
    @Size(max = 4000)
    @Column(name = "pic2")
    private String pic2;
    @Size(max = 4000)
    @Column(name = "pic3")
    private String pic3;
    @Size(max = 4000)
    @Column(name = "pic4")
    private String pic4;
    @Size(max = 4000)
    @Column(name = "pic5")
    private String pic5;
    @Column(name = "category_id")
    private Integer categoryId;
    @Size(max = 45)
    @Column(name = "varietal")
    private String varietal;
    @Size(max = 45)
    @Column(name = "alcohool")
    private String alcohool;
    @Size(max = 45)
    @Column(name = "region")
    private String region;
    @Size(max = 45)
    @Column(name = "year")
    private String year;
    @Size(max = 45)
    @Column(name = "mevushal")
    private String mevushal;
    @Size(max = 45)
    @Column(name = "brand")
    private String brand;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantityInStock")
    private Double quantityInStock;
    @Column(name = "buyPrice")
    private Double buyPrice;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private ProductCarousel productCarousel;

    public Product() {
    }

    public Product(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetaTagTitle() {
        return metaTagTitle;
    }

    public void setMetaTagTitle(String metaTagTitle) {
        this.metaTagTitle = metaTagTitle;
    }

    public String getMetaTagDescription() {
        return metaTagDescription;
    }

    public void setMetaTagDescription(String metaTagDescription) {
        this.metaTagDescription = metaTagDescription;
    }

    public String getMetaTagKeywords() {
        return metaTagKeywords;
    }

    public void setMetaTagKeywords(String metaTagKeywords) {
        this.metaTagKeywords = metaTagKeywords;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getPic3() {
        return pic3;
    }

    public void setPic3(String pic3) {
        this.pic3 = pic3;
    }

    public String getPic4() {
        return pic4;
    }

    public void setPic4(String pic4) {
        this.pic4 = pic4;
    }

    public String getPic5() {
        return pic5;
    }

    public void setPic5(String pic5) {
        this.pic5 = pic5;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getVarietal() {
        return varietal;
    }

    public void setVarietal(String varietal) {
        this.varietal = varietal;
    }

    public String getAlcohool() {
        return alcohool;
    }

    public void setAlcohool(String alcohool) {
        this.alcohool = alcohool;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMevushal() {
        return mevushal;
    }

    public void setMevushal(String mevushal) {
        this.mevushal = mevushal;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Double quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public ProductCarousel getProductCarousel() {
        return productCarousel;
    }

    public void setProductCarousel(ProductCarousel productCarousel) {
        this.productCarousel = productCarousel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.itfox.entity.Product[ productId=" + productId + " ]";
    }
    
}
