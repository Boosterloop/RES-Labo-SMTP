/*
 * Auteurs : Alexandre Monteiro Marques, Alison Savary
 *
 * Cours : RES
 * Laboratoire : SMTP
 *
 * Date : 1 Avril 2019
 *
 */

package model.mail;

public class Mail {
    private String from = null;
    private String[] to = null;
    private String[] cc = null;
    private String[] bcc = null;
    private String subject = null;
    private String message = null;

    /**
     * @return expediteur du mail
     */
    public String getFrom() {
        return from;
    }

    /**
     * @return les destinataires
     */
    public String[] getTo() {
        return to;
    }

    /**
     * @return les destinataires en copie
     */
    public String[] getCc() {
        return cc;
    }

    /**
     * @return les destinataires en copie caché
     */
    public String[] getBcc() {
        return bcc;
    }

    /**
     * @return le sujet du mail
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @return le message du mail
     */
    public String getMessage() {
        return message;
    }

    /**
     * Defini l'expeditaire du mail
     * @param from l'expeditaire du mail
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Defini les destinaire du mail
     * @param to les destinataires du mail
     */
    public void setTo(String[] to) {
        this.to = to;
    }

    /**
     * Defini les destinaires en copie du mail
     * @param cc des destinataires
     */
    public void setCc(String[] cc) {
        this.cc = cc;
    }

    /**
     * Defini les destinataire en copie caché du mail
     * @param bcc
     */
    public void setBcc(String[] bcc) {
        this.bcc = bcc;
    }

    /**
     * Defini le sujet du mail
     * @param subject le sujet du mail
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Defini le message du mail
     * @param message message du mail
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
