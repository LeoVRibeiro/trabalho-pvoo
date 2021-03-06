/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import java.math.BigDecimal;
import java.time.LocalDate;


/**
 *
 * @author Leonardo
 */
public class ContaCorrente {
    private long id;
    private BigDecimal saldo = new BigDecimal("0");
    private Cliente titular;
   
    public ContaCorrente(long id, Cliente titular, BigDecimal valor){
        this.id = id;
        this.titular = titular;
        this.saldo = saldo.add(valor);
    }
    
    public ContaCorrente(Cliente titular, BigDecimal valor){
        this.titular = titular;
        this.saldo = saldo.add(valor);
    }
    
    public ContaCorrente(long id){
        this.id = id;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public boolean setSaldo(BigDecimal quantia){
        this.saldo = quantia;
        return true;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void depositar(BigDecimal valor, LocalDate hoje) {
        this.saldo = saldo.add(valor);
    }
    
    public boolean adicionaJuros(){
        
        return false;
    }
    
    public boolean pagarManutencao(LocalDate dataAtual){
        
        if(dataAtual.getDayOfMonth() == 15){
            BigDecimal taxaManutencao = new BigDecimal("20");
            this.saldo = saldo.subtract(taxaManutencao);
            return true;
        }
        return false;
    }
    
    /**
     * Além de realizar o saque, também salva a data, operação e valor em um array de Extratos
     * @param BigDecimal valor
     * @param LocalDate hoje 
     */
    public void sacar(BigDecimal valor){
        
        this.saldo = saldo.subtract(valor);
    }
    public void transferirCP(ContaPoupanca cp, BigDecimal valor, LocalDate hoje){
        this.saldo = saldo.subtract(valor);
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

   
    /**
     * Compara o número de duas contas
     * @return true ou false
     */
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContaCorrente other = (ContaCorrente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" + "id=" + id + ", saldo=" + saldo + ", titular=" + titular + '}';
    }

  

    
    
    
    
    
}
