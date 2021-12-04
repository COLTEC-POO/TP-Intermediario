import java.util.Scanner;

public class Restaurante {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        byte Menu;
        int SubMenu;

        Mesa [] mesas;
        mesas = new Mesa [2];

        Garcon neymar;
        neymar = new Garcon();
        neymar.setNome("Neymar");
        neymar.setCodigo(100);

        Gerente cleber;
        cleber = new Gerente();
        cleber.setNome("Cleber");
        cleber.setCodigo(101);

        //Menu
        do {
            System.out.println();
            System.out.println("- Restaurante Roubo -");
            System.out.println("1- Abrir mesas ");
            System.out.println("2- Fazer pedidos");
            System.out.println("3- Visualizar Pedidos");
            System.out.println("4- Fechar Mesas");
            System.out.println("5- Sair");
            System.out.print("Digite a opção desejada: ");
            Menu = input.nextByte();
            System.out.println();

            switch (Menu) {
                case 0:
                    break;
                case 1: {
                    System.out.println("Painel de Mesas ");
                    mesas[Mesa.getQtyMesas()] = neymar.novaMesa(2);
                    break;
                }
                case 2: {
                    do {
                        System.out.println("Cardapio - Restaurante Roubo: ");
                        System.out.println("1. X-Tudo Valor: $50.00");
                        System.out.println("2. Pastel de Frango: $35.00");
                        System.out.println("3. Coca-Cola 2L: $25.00");
                        System.out.println("4. Sorvete Casquinha: $8.00");
                        System.out.println("5. Voltar ao menu principal");
                        System.out.print("Digite a opção desejada: ");
                        System.out.println();
                        SubMenu = sc.nextInt();

                        switch (SubMenu) {
                            case 1: {
                                Pedido pedido;
                                pedido = new Pedido("X-Tudo", 50.00);
                                neymar.fazerPedido(mesas[Mesa.getQtyMesas() - 1], pedido);
                                break;
                            }
                            case 2: {
                                Pedido pedido;
                                pedido = new Pedido("Pastel de Frango", 35.00);
                                neymar.fazerPedido(mesas[Mesa.getQtyMesas() - 1], pedido);
                                break;
                            }
                            case 3: {
                                Pedido pedido;
                                pedido = new Pedido("Coca-Cola 2L", 25.00);
                                neymar.fazerPedido(mesas[Mesa.getQtyMesas() - 1], pedido);
                                break;
                            }
                            case 4: {
                                Pedido pedido;
                                pedido = new Pedido("Sorvete Casquinha", 8.00);
                                neymar.fazerPedido(mesas[Mesa.getQtyMesas() - 1], pedido);
                                break;
                            }
                        }
                    } while (SubMenu != 5);
                    break;
                }
                case 3: {
                    System.out.println("Historico de Pedidos: ");
                    cleber.visualizarPedidos(mesas[Mesa.getQtyMesas() - 1]);
                    break;
                }
                case 4: {
                    System.out.println("Fechando Mesa..");
                    neymar.fecharMesa(mesas[Mesa.getQtyMesas() - 1]);
                    System.out.println("Historico limpo: ");
                    cleber.visualizarPedidos(mesas[Mesa.getQtyMesas() - 1]);
                    break;
                }
                case 5: {
                    System.out.println("Saindo do restaurante...");
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Error: Você escolheu uma opção invalida...");
                }
            }
        } while (Menu != 5);
    }
}
