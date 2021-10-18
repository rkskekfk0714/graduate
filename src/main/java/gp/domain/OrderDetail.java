package gp.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name ="orderdetail")
public class OrderDetail {

    @Id
    @Column(name = "orderdetailkey")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderdetailkey;

    @JoinColumn(name = "orderkey")
    @OneToOne
    private Order order;

    @JoinColumn(name = "materialkey")
    @ManyToOne
    private Material material;

    @Column(name = "materialname")
    private String materialname;

    @Column(name = "ordernum")
    private int ordernum;

    @Builder
    public OrderDetail(Long orderdetailkey, Order order, Material material, String materialname, int ordernum){
        this.orderdetailkey=orderdetailkey;
        this.order=order;
        this.material=material;
        this.materialname=materialname;
        this.ordernum=ordernum;
    }


}
