﻿<%@ Page Language="C#" MasterPageFile="~/backstage/MasterPage.master" AutoEventWireup="true" CodeFile="patient.aspx.cs" Inherits="backstage_patient" %>

<asp:Content ID="Content1" ContentPlaceHolderID="CPH1" runat="Server">
    <div class="container">
        <form id="fomr1" runat="server">
            <asp:GridView ID="gvPatients" runat="server" CssClass="table" AutoGenerateColumns="False"></asp:GridView>
        </form>
    </div>
</asp:Content>