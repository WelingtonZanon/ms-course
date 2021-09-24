# Microsserviços Java com Spring Boot e Spring Cloud


Comunicação simples entre duas entidades **Worker** e **Payroll**.

**gateway-zuul** para fazer o controle de portas aleatórias.

**eureka-server** para fazer o registro dos serviço.

**config-server** utilizando Cloud controle para acesso iteração de configuração externa com Git.

### Tolerância a falhas com Hystrix

### 2.6 Timeout de Hystrix e Ribbon

```
hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=60000
ribbon.ConnectTimeout=10000
ribbon.ReadTimeout=20000
```

##### Importante:  versão do Spring usado "2.3.4.RELEASE", algumas bibliotecas podem não funcionar corretamente em versões superiores.

#### Tecnologias

* 2.3.4.RELEASE
* netflix-eureka
* spring-web
* lombok
* h2 BataBase 
* maven
* spring-jpa

### Como funciona o projeto

Clone o mono repo com os cinco projetos e suba primeiro o gateway-zuul, depois as configurações, o eureka-server e dai os domínios restantes.

Aguarde alguns minutos para que o Servidor Eureka estabilize os serviços. 

O banco H2 sobe junto com o Woker com algumas entradas prontas para teste.

Os endpoint são gerenciados pela junção do gatway que faz o controle das portas mais a camada de controle definida.

domínio controlado pelo zuul gateway http://localhost:8765/hr-worker/ +

endpoint

* workers = para resultado de todos os cadastros

*  workers/idCadastrado = para sonultar cadastro especifico
* hr-payroll/payments/idCadastrado/days/quantidadeDias = consultar soma salario de um trabalhador cadastrado.

Checa arquivo externo gerenciado pelo cloud server.

http://localhost:8765/hr-worker/workers/configs

Recarrega arquivo externo sem a necessidade de para os serviços

http://localhost:8765/hr-worker/actuator/refresh

Arquivo externo monitorado pelo projeto de micro serviços

https://github.com/WelingtonZanon/ms-course-configs

