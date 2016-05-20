<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="<c:url value='/css/stylesheet.css' />">
    </head>
    <body>
        <h1>BudgIt REST API</h1>

        <h2>Get all categories</h2>
        <dl>
            <dt>
                URL:
            </dt>
            <dd>
            	<a href="/IP_REST/categories">/IP_REST/categories</a>
            </dd>
            <dt>
                Method:
            </dt>
            <dd>
                GET
            </dd>
            <dt>
                Parameters:
            </dt>
            <dd>
                /
            </dd>
            <dt>
                Result:
            </dt>
            <dd>
                A list of all categories
            </dd>
            <dt>
                Example:
            </dt>
            <dd>
            	<a href="/IP_REST/categories">/IP_REST/categories</a>
            </dd>
        </dl>

        <h2>Get a single category by id</h2>
        <dl>
            <dt>
                URL:
            </dt>
            <dd>
            	<a href="/IP_REST/categories/{id}">/IP_REST/categories/{id}</a>
            </dd>
            <dt>
                Method:
            </dt>
            <dd>
                GET
            </dd>
            <dt>
                Parameters:
            </dt>
            <dd>
                (URL) The id of the requested category
            </dd>
            <dt>
                Result:
            </dt>
            <dd>
                A single category
            </dd>
            <dt>
                Example:
            </dt>
            <dd>
            	<a href="/IP_REST/categories/0">/IP_REST/categories/1</a>
            </dd>
        </dl>

        <h2>Add a new category</h2>
        <dl>
            <dt>
                URL:
            </dt>
            <dd>
            	<a href="/IP_REST/categories">/IP_REST/categories</a>
            </dd>
            <dt>
                Method:
            </dt>
            <dd>
                POST
            </dd>
            <dt>
                Parameters:
            </dt>
            <dd>
                The JSON representation of the new category ("name" or "name" and "expenses")
            </dd>
            <dt>
                Result:
            </dt>
            <dd>
                /
            </dd>
            <dt>
                Example:
            </dt>
            <dd>
                <dl>
                	<dt>
                		URL:
                	</dt>
                	<dd>
                		<a href="/IP_REST/categories">/IP_REST/categories</a>
                	</dd>
                	<dt>
                		Body:
                	</dt>
                	<dd>
                		<pre>
{
    "name": "Shopping"
}
                		</pre>
                	</dd>
                </dl>
            </dd>
        </dl>

        <h2>Edit a category by id</h2>
        <dl>
            <dt>
                URL:
            </dt>
            <dd>
            	<a href="/IP_REST/categories/{id}">/IP_REST/categories/{id}</a>
            </dd>
            <dt>
                Method:
            </dt>
            <dd>
                UPDATE
            </dd>
            <dt>
                Parameters:
            </dt>
            <dd>
                The JSON representation of the edited category ("name" or "name" and "expenses")
            </dd>
            <dt>
                Result:
            </dt>
            <dd>
                /
            </dd>
            <dt>
                Example:
            </dt>
            <dd>
                <dl>
                	<dt>
                		URL:
                	</dt>
                	<dd>
                		<a href="/IP_REST/categories/0">/IP_REST/categories/0</a>
                	</dd>
                	<dt>
                		Body:
                	</dt>
                	<dd>
                		<pre>
{
    "name": "Shopping"
}
                		</pre>
                	</dd>
                </dl>
            </dd>
        </dl>

        <h2>Delete a category by id</h2>
        <dl>
            <dt>
                URL:
            </dt>
            <dd>
            	<a href="/IP_REST/categories/{id}">/IP_REST/categories/{id}</a>
            </dd>
            <dt>
                Method:
            </dt>
            <dd>
                DELETE	
            </dd>
            <dt>
                Parameters:
            </dt>
            <dd>
                (URL) The id of the category to be deleted
            </dd>
            <dt>
                Result:
            </dt>
            <dd>
                /
            </dd>
            <dt>
                Example:
            </dt>
            <dd>
            	<a href="/IP_REST/categories/0">/IP_REST/categories/0</a>
            </dd>
        </dl>
    </body>
</html>